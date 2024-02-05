package LLDQuestions.Lift.SelectionStratergy;

import LLDQuestions.Lift.Direction;
import LLDQuestions.Lift.ElevatorCar;
import LLDQuestions.Lift.ElevatorController;
import LLDQuestions.Lift.ElevatorSystem;

import java.util.List;

 public interface ElevatorSelectionStrategy {

    public ElevatorCar selectElevator(int floor, Direction dir);
}

