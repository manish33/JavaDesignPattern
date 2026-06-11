# Splitwise - Low Level Design

## Design Patterns Used

| Pattern | Where | Purpose |
|---------|-------|---------|
| **Strategy** | `SplitStrategy` + implementations | Interchangeable split algorithms (Equal, Exact, Percent) |
| **Factory** | `SplitStrategyFactory` | Creates the correct strategy based on `SplitType` |
| **Facade** | `SplitwiseService` | Single entry point hiding internal service complexity |
| **Repository** | `UserRepository`, `GroupRepository`, `ExpenseRepository` | Abstracts data access from business logic |
| **SRP** | Separate services | Each service handles one responsibility |

---

## Class Diagram

```mermaid
classDiagram
    direction TB

    %% ===== MODELS =====
    class User {
        -String id
        -String name
        -String email
        -String phone
        +getId() String
        +getName() String
    }

    class Group {
        -String id
        -String name
        -String description
        -String createdBy
        -List~String~ memberIds
        -List~String~ expenseIds
        +addMember(userId)
        +removeMember(userId)
        +hasMember(userId) boolean
        +addExpense(expenseId)
    }

    class Expense {
        -String id
        -double amount
        -String description
        -String paidByUserId
        -List~Split~ splits
        -SplitType splitType
        -String groupId
        -ExpenseMetadata metadata
        +isGroupExpense() boolean
    }

    class Split {
        -String userId
        -double amount
        +getUserId() String
        +getAmount() double
    }

    class SplitType {
        <<enumeration>>
        EQUAL
        EXACT
        PERCENT
    }

    class ExpenseMetadata {
        -String name
        -String imgUrl
        -String notes
    }

    %% ===== STRATEGY PATTERN =====
    class SplitStrategy {
        <<interface>>
        +split(amount, userIds, values) List~Split~
        +validate(amount, userIds, values) boolean
    }

    class EqualSplitStrategy {
        +split(amount, userIds, values) List~Split~
        +validate(amount, userIds, values) boolean
    }

    class ExactSplitStrategy {
        +split(amount, userIds, values) List~Split~
        +validate(amount, userIds, values) boolean
    }

    class PercentSplitStrategy {
        +split(amount, userIds, values) List~Split~
        +validate(amount, userIds, values) boolean
    }

    class SplitStrategyFactory {
        -Map~SplitType,SplitStrategy~ STRATEGIES
        +getStrategy(type)$ SplitStrategy
    }

    %% ===== REPOSITORIES =====
    class UserRepository {
        -Map~String,User~ users
        +save(user)
        +findById(id) Optional~User~
        +getById(id) User
        +findAll() List~User~
        +exists(id) boolean
    }

    class GroupRepository {
        -Map~String,Group~ groups
        +save(group)
        +getById(id) Group
        +findAll() List~Group~
        +findByMember(userId) List~Group~
    }

    class ExpenseRepository {
        -Map~String,Expense~ expenses
        +save(expense)
        +findById(id) Optional~Expense~
        +findAll() List~Expense~
        +findByGroup(groupId) List~Expense~
    }

    %% ===== SERVICES =====
    class UserService {
        -UserRepository userRepository
        +addUser(user)
        +getUser(userId) User
        +getAllUsers() List~User~
    }

    class GroupService {
        -GroupRepository groupRepository
        -UserRepository userRepository
        +createGroup(id, name, desc, createdBy) Group
        +addMember(groupId, userId)
        +removeMember(groupId, userId)
        +getGroup(groupId) Group
        +getGroupsForUser(userId) List~Group~
    }

    class BalanceService {
        -Map balances
        -Map groupBalances
        +registerUser(userId)
        +recordExpense(paidBy, splits, groupId)
        +getUserBalance(userId) Map
        +getAllBalances() Map
        +getGroupBalances(groupId) Map
    }

    class ExpenseService {
        -ExpenseRepository expenseRepository
        -BalanceService balanceService
        +createExpense(...) Expense
        +getExpensesByGroup(groupId) List~Expense~
    }

    class SplitwiseService {
        -UserService userService
        -GroupService groupService
        -ExpenseService expenseService
        -BalanceService balanceService
        +addUser(id, name, email, phone)
        +createGroup(id, name, desc, createdBy) Group
        +addMemberToGroup(groupId, userId)
        +addExpense(...) Expense
        +showBalance(userId)
        +showAllBalances()
        +showGroupBalances(groupId)
    }

    class Driver {
        +main(args)$
        -handleShow(splitwise, parts)$
        -handleExpense(splitwise, parts, groupId)$
        -handleGroupExpense(splitwise, parts)$
    }

    %% ===== EXCEPTION =====
    class InvalidExpenseException {
        +InvalidExpenseException(message)
    }

    %% ===== RELATIONSHIPS =====
    Expense --> Split : contains *
    Expense --> SplitType
    Expense --> ExpenseMetadata

    SplitStrategy <|.. EqualSplitStrategy
    SplitStrategy <|.. ExactSplitStrategy
    SplitStrategy <|.. PercentSplitStrategy

    SplitStrategyFactory --> SplitStrategy : creates
    SplitStrategyFactory --> SplitType : uses

    UserRepository --> User : stores
    GroupRepository --> Group : stores
    ExpenseRepository --> Expense : stores

    UserService --> UserRepository
    GroupService --> GroupRepository
    GroupService --> UserRepository
    ExpenseService --> ExpenseRepository
    ExpenseService --> BalanceService
    ExpenseService --> SplitStrategyFactory : uses

    SplitwiseService --> UserService
    SplitwiseService --> GroupService
    SplitwiseService --> ExpenseService
    SplitwiseService --> BalanceService

    Driver --> SplitwiseService

    InvalidExpenseException --|> RuntimeException
```

---

## Package Structure

```
SplitWiseMachineCoding/
├── model/
│   ├── User.java              # Immutable user entity
│   ├── Group.java             # Group with members & expenses
│   ├── Expense.java           # Immutable expense record
│   └── ExpenseMetadata.java   # Optional metadata
├── split/
│   ├── SplitType.java         # Enum: EQUAL, EXACT, PERCENT
│   └── Split.java             # Value object: userId + amount
├── strategy/
│   ├── SplitStrategy.java     # Strategy interface
│   ├── EqualSplitStrategy.java
│   ├── ExactSplitStrategy.java
│   ├── PercentSplitStrategy.java
│   └── SplitStrategyFactory.java
├── repository/
│   ├── UserRepository.java
│   ├── GroupRepository.java
│   └── ExpenseRepository.java
├── service/
│   ├── UserService.java       # User CRUD
│   ├── GroupService.java      # Group management
│   ├── ExpenseService.java    # Expense creation + validation
│   ├── BalanceService.java    # Balance sheet tracking
│   └── SplitwiseService.java  # Facade
├── exception/
│   └── InvalidExpenseException.java
└── Driver.java                # CLI entry point
```

---

## Supported Commands

| Command | Format | Example |
|---------|--------|---------|
| Show all balances | `SHOW` | `SHOW` |
| Show user balance | `SHOW userId` | `SHOW u1` |
| Add expense | `EXPENSE paidBy amount n u1..un type [values]` | `EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL` |
| Group expense | `GROUP_EXPENSE gId paidBy amount n u1..un type [values]` | `GROUP_EXPENSE g1 u1 600 3 u1 u2 u3 EQUAL` |
| Group balances | `GROUP_SHOW groupId` | `GROUP_SHOW g1` |
| Create group | `CREATE_GROUP groupId name createdBy` | `CREATE_GROUP g2 Office u1` |
| Add member | `ADD_MEMBER groupId userId` | `ADD_MEMBER g2 u3` |

---

## Flow Diagram

```mermaid
sequenceDiagram
    participant D as Driver
    participant F as SplitwiseService<br>(Facade)
    participant ES as ExpenseService
    participant SF as SplitStrategyFactory
    participant S as SplitStrategy
    participant BS as BalanceService
    participant GS as GroupService

    D->>F: addExpense(paidBy, amount, users, type, groupId)
    F->>ES: createExpense(...)
    ES->>SF: getStrategy(splitType)
    SF-->>ES: SplitStrategy
    ES->>S: validate(amount, users, values)
    S-->>ES: true
    ES->>S: split(amount, users, values)
    S-->>ES: List<Split>
    ES->>BS: recordExpense(paidBy, splits, groupId)
    BS-->>ES: done
    ES-->>F: Expense
    F->>GS: getGroup(groupId).addExpense(id)
    F-->>D: Expense
```
