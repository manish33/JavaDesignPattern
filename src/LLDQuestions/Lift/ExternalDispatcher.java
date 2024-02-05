package LLDQuestions.Lift;


public class ExternalDispatcher {

    public static ExternalDispatcher INSTANCE = new ExternalDispatcher();
    private ExternalDispatcher()
    {
    }

    public  void submitRequest(int floor, Direction dir)
    {
        ElevatorCar elevator= ElevatorSystem.elevatorSelectionStrategy.selectElevator(floor, dir);
        System.out.println("Selected elevator " + elevator.getId());
        ElevatorController elevatorController = elevator.getElevatorController();
        elevatorController.acceptRequest(floor,dir);
    }
}

