package LLDQuestions.Lift;


public class ElevatorCar {
    private int id;
    private Door door;
    private Display display;
    private Button button;
    private int currentFloor;  //updated while elevator moves to each floor
    private Direction dir; //updated every time elevator changes direction
    private ElevatorController elevatorController;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public int getId() {
        return id;
    }

    public ElevatorController getElevatorController() {
        return elevatorController;
    }

    public void setElevatorController(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    public ElevatorCar(int id)
    {
        this.id= id;
        door= new Door();
        display= new Display();
        currentFloor= 0;
        dir= Direction.NONE;
        button= new InternalButton();

    }

    public void move(Direction dir, int floor)
    {
        System.out.println("Elevator " + id + "moving " + dir);
        System.out.println("Elevator " + id + "stops at floor " + floor);
        door.open(id);
        door.close(id);

        //called everytime when currFloor value changes
        setDisplay();

    }

    public void pressButton(int floor)
    {
        Direction dir= Direction.NONE;
        if(floor>currentFloor)
            dir= Direction.UP;
        else if(floor<currentFloor)
            dir= Direction.DOWN;
        button.pressButton(floor, dir, id);
    }


    private void setDisplay()
    {
        display.setFloor(currentFloor);
        display.setDir(dir);

    }


}

