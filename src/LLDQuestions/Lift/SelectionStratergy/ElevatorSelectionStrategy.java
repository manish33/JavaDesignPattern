package LLDQuestions.Lift.SelectionStratergy;

import LLDQuestions.Lift.Direction;
import LLDQuestions.Lift.ElevatorCar;
import LLDQuestions.Lift.ElevatorController;
import LLDQuestions.Lift.ElevatorSystem;

import java.util.List;

public class ElevatorSelectionStrategy {
    protected List<ElevatorController> elevatorControllerList = ElevatorSystem.INSTANCE.getElevatorControllerList();


    public ElevatorCar selectElevator(int floor, Direction dir) {
        return null;
    }
}

