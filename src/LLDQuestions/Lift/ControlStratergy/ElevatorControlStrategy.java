package LLDQuestions.Lift.ControlStratergy;

import LLDQuestions.Lift.ElevatorController;
import LLDQuestions.Lift.ElevatorSystem;
import LLDQuestions.Lift.PendingRequests;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public interface ElevatorControlStrategy {
    //queue storing pending requests in form of
    public void moveElevator(ElevatorController elevatorController);
}
