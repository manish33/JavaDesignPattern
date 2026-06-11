package LLDQuestions.SplitWiseMachineCoding.service;

import LLDQuestions.SplitWiseMachineCoding.model.Expense;
import LLDQuestions.SplitWiseMachineCoding.model.Group;
import LLDQuestions.SplitWiseMachineCoding.model.User;
import LLDQuestions.SplitWiseMachineCoding.repository.ExpenseRepository;
import LLDQuestions.SplitWiseMachineCoding.repository.GroupRepository;
import LLDQuestions.SplitWiseMachineCoding.repository.UserRepository;
import LLDQuestions.SplitWiseMachineCoding.split.SplitType;

import java.util.List;
import java.util.Map;

/**
 * Facade that ties together all services.
 * Single entry point for all Splitwise operations.
 */
public class SplitwiseService {
    private final UserService userService;
    private final GroupService groupService;
    private final ExpenseService expenseService;
    private final BalanceService balanceService;

    public SplitwiseService() {
        UserRepository userRepository = new UserRepository();
        GroupRepository groupRepository = new GroupRepository();
        ExpenseRepository expenseRepository = new ExpenseRepository();

        this.balanceService = new BalanceService();
        this.userService = new UserService(userRepository);
        this.groupService = new GroupService(groupRepository, userRepository);
        this.expenseService = new ExpenseService(expenseRepository, balanceService);
    }

    // ========== User Operations ==========

    public void addUser(String id, String name, String email, String phone) {
        User user = new User(id, name, email, phone);
        userService.addUser(user);
        balanceService.registerUser(id);
    }

    public User getUser(String userId) {
        return userService.getUser(userId);
    }

    // ========== Group Operations ==========

    public Group createGroup(String groupId, String name, String description, String createdBy) {
        return groupService.createGroup(groupId, name, description, createdBy);
    }

    public void addMemberToGroup(String groupId, String userId) {
        groupService.addMember(groupId, userId);
    }

    public void removeMemberFromGroup(String groupId, String userId) {
        groupService.removeMember(groupId, userId);
    }

    public List<Group> getUserGroups(String userId) {
        return groupService.getGroupsForUser(userId);
    }

    // ========== Expense Operations ==========

    public Expense addExpense(String paidByUserId, double amount, String description,
                              List<String> participantIds, List<Double> values,
                              SplitType splitType, String groupId) {

        Expense expense = expenseService.createExpense(amount, description, paidByUserId,
                participantIds, values, splitType, groupId, null);

        if (groupId != null) {
            groupService.getGroup(groupId).addExpense(expense.getId());
        }
        return expense;
    }

    // ========== Balance Display ==========

    public void showBalance(String userId) {
        String userName = userService.getUser(userId).getName();
        Map<String, Double> userBalance = balanceService.getUserBalance(userId);
        boolean hasBalance = false;

        for (Map.Entry<String, Double> entry : userBalance.entrySet()) {
            double amount = entry.getValue();
            if (Math.abs(amount) < 0.01) continue;

            hasBalance = true;
            String otherName = userService.getUser(entry.getKey()).getName();
            if (amount < 0) {
                System.out.printf("%s owes %s: %.2f%n", userName, otherName, Math.abs(amount));
            } else {
                System.out.printf("%s owes %s: %.2f%n", otherName, userName, amount);
            }
        }
        if (!hasBalance) {
            System.out.println("No balances");
        }
    }

    public void showAllBalances() {
        Map<String, Map<String, Double>> all = balanceService.getAllBalances();
        boolean hasBalance = false;

        for (Map.Entry<String, Map<String, Double>> entry : all.entrySet()) {
            for (Map.Entry<String, Double> bal : entry.getValue().entrySet()) {
                if (bal.getValue() > 0.01) {
                    hasBalance = true;
                    String owes = userService.getUser(bal.getKey()).getName();
                    String owed = userService.getUser(entry.getKey()).getName();
                    System.out.printf("%s owes %s: %.2f%n", owes, owed, bal.getValue());
                }
            }
        }
        if (!hasBalance) {
            System.out.println("No balances");
        }
    }

    public void showGroupBalances(String groupId) {
        Group group = groupService.getGroup(groupId);
        Map<String, Map<String, Double>> gBalances = balanceService.getGroupBalances(groupId);
        boolean hasBalance = false;

        System.out.println("--- Group: " + group.getName() + " ---");
        for (Map.Entry<String, Map<String, Double>> entry : gBalances.entrySet()) {
            for (Map.Entry<String, Double> bal : entry.getValue().entrySet()) {
                if (bal.getValue() > 0.01) {
                    hasBalance = true;
                    String owes = userService.getUser(bal.getKey()).getName();
                    String owed = userService.getUser(entry.getKey()).getName();
                    System.out.printf("  %s owes %s: %.2f%n", owes, owed, bal.getValue());
                }
            }
        }
        if (!hasBalance) {
            System.out.println("  No balances");
        }
    }
}
