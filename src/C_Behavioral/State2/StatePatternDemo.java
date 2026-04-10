package C_Behavioral.State2;

// 1. The State Interface
interface State {
    void insertCoin();
    void ejectCoin();
    void selectItem();
    void dispense();
}

// 2. The Context Class (Vending Machine)
class VendingMachine {
    State idleState;
    State hasCoinState;
    State soldState;

    State currentState;
    int count = 0;

    public VendingMachine(int numberSodas) {
        idleState = new IdleState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);

        this.count = numberSodas;
        if (numberSodas > 0) {
            currentState = idleState;
        }
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void ejectCoin() {
        currentState.ejectCoin();
    }

    public void selectItem() {
        currentState.selectItem();
        currentState.dispense();
    }

    void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    void releaseItem() {
        System.out.println("A soda comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    public State getIdleState() { return idleState; }
    public State getHasCoinState() { return hasCoinState; }
    public State getSoldState() { return soldState; }
    public int getCount() { return count; }
}

// 3. Concrete State: Idle
class IdleState implements State {
    VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    public void insertCoin() {
        System.out.println("Coin inserted.");
        machine.setCurrentState(machine.getHasCoinState());
    }

    public void ejectCoin() {
        System.out.println("You haven't inserted a coin.");
    }

    public void selectItem() {
        System.out.println("You need to insert a coin first.");
    }

    public void dispense() {
        System.out.println("You need to pay first.");
    }
}

// 4. Concrete State: Has Coin
class HasCoinState implements State {
    VendingMachine machine;

    public HasCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    public void insertCoin() {
        System.out.println("You can't insert another coin.");
    }

    public void ejectCoin() {
        System.out.println("Coin returned.");
        machine.setCurrentState(machine.getIdleState());
    }

    public void selectItem() {
        System.out.println("Item selected...");
        machine.setCurrentState(machine.getSoldState());
    }

    public void dispense() {
        System.out.println("No item dispensed yet.");
    }
}

// 5. Concrete State: Sold
class SoldState implements State {
    VendingMachine machine;

    public SoldState(VendingMachine machine) {
        this.machine = machine;
    }

    public void insertCoin() {
        System.out.println("Please wait, we are giving you a soda.");
    }

    public void ejectCoin() {
        System.out.println("Sorry, you already turned the crank.");
    }

    public void selectItem() {
        System.out.println("Turning twice doesn't get you another soda!");
    }

    public void dispense() {
        machine.releaseItem();
        if (machine.getCount() > 0) {
            machine.setCurrentState(machine.getIdleState());
        } else {
            System.out.println("Oops, out of sodas!");
            machine.setCurrentState(machine.getIdleState()); // Or transition to a SoldOutState
        }
    }
}

// 6. Main Class to Run the Demo
public class StatePatternDemo {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(5);

        System.out.println("--- Test 1: Normal Transaction ---");
        machine.insertCoin();
        machine.selectItem();

        System.out.println("\n--- Test 2: Ejecting Coin ---");
        machine.insertCoin();
        machine.ejectCoin();

        System.out.println("\n--- Test 3: Invalid Action ---");
        machine.selectItem();
    }
}