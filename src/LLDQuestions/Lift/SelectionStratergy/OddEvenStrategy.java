package LLDQuestions.Lift.SelectionStratergy;

import LLDQuestions.Lift.Direction;
import LLDQuestions.Lift.ElevatorCar;
import LLDQuestions.Lift.ElevatorController;
import LLDQuestions.Lift.ElevatorSystem;
import LLDQuestions.Lift.SelectionStratergy.ElevatorSelectionStrategy;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class OddEvenStrategy implements ElevatorSelectionStrategy {

    @Override
    public ElevatorCar selectElevator(int floor, Direction dir) {
        List<ElevatorController> elevatorControllerList = ElevatorSystem.INSTANCE.getElevatorControllerList();
        for(ElevatorController eController: elevatorControllerList)
        {
            //odd elevator for odd floors and even elevators for even floors
            //select elevator which is moving in same direction which is requested or IDLE elevator
            if(floor%2 == eController.getId()%2)
            {
                int currFloor= eController.getElevatorCar().getCurrentFloor();
                Direction currDir= eController.getElevatorCar().getDir();
                if(floor>currFloor && currDir==Direction.UP)
                    return eController.getElevatorCar();
                else if(floor<currFloor && currDir==Direction.DOWN)
                    return eController.getElevatorCar();
                else if(currDir==Direction.NONE)
                    return eController.getElevatorCar();

            }
        }
        return elevatorControllerList.get(ThreadLocalRandom.current().nextInt(1, elevatorControllerList.size())).getElevatorCar();
    }
}
