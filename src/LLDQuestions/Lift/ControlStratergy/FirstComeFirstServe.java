package LLDQuestions.Lift.ControlStratergy;

import LLDQuestions.Lift.Direction;
import LLDQuestions.Lift.ElevatorController;
import LLDQuestions.Lift.PendingRequests;


public class FirstComeFirstServe implements ElevatorControlStrategy {

    public void moveElevator(ElevatorController elevatorController)
    {
        //poll each requests out of queue one by one
        //move elevator according to each request
        //Disadvantage: frequent change of direction of elevator, hence inefficient and
        // long waiting time for users
        PendingRequests pendingRequest = elevatorController.getPendingRequestList().poll();
        Direction direction = elevatorController.getElevatorCar().getCurrentFloor()>pendingRequest.getFloor()?Direction.UP:Direction.DOWN;
        elevatorController.getElevatorCar().move(direction,pendingRequest.getFloor());
    }
}

