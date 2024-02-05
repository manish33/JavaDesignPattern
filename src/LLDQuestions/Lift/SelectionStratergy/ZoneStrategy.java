package LLDQuestions.Lift.SelectionStratergy;

import LLDQuestions.Lift.Direction;
import LLDQuestions.Lift.ElevatorCar;
import LLDQuestions.Lift.ElevatorController;
import LLDQuestions.Lift.ElevatorSystem;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ZoneStrategy implements ElevatorSelectionStrategy {
    @Override
    public ElevatorCar selectElevator(int floor, Direction dir) {
        List<ElevatorController> elevatorControllerList = ElevatorSystem.INSTANCE.getElevatorControllerList();

        for(ElevatorController eController: elevatorControllerList)
        {
            //assign elevators according to zones in building
            //out of these elevators select the elevator which is going in the same direction or is idle
        }
        return elevatorControllerList.get(ThreadLocalRandom.current().nextInt(1, elevatorControllerList.size())).getElevatorCar();
    }
}
