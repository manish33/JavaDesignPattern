package LLDQuestions.Lift;

public class InternalDispatcher {

    public  void submitRequest(int floor, Direction dir, int elevatorId)
    {
        for(ElevatorController eController: ElevatorSystem.INSTANCE.getElevatorControllerList())
        {
            if(eController.getId()== elevatorId)
            {
                eController.acceptRequest(floor, dir);
            }
        }
    }
}
