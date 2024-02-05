package LLDQuestions.Lift.ControlStratergy;

import LLDQuestions.Lift.Direction;
import LLDQuestions.Lift.ElevatorController;
import LLDQuestions.Lift.PendingRequests;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ScanAlgorithm implements ElevatorControlStrategy {

    public void moveElevator(ElevatorController elevatorController)
    {
        if(!elevatorController.getPendingRequestList().isEmpty()){
            if(elevatorController.getElevatorCar().getDir()== Direction.UP || elevatorController.getElevatorCar().getDir()== Direction.NONE){
                if(!elevatorController.getUpPendingRequest().isEmpty()){
                    PriorityQueue<PendingRequests> upPendingRequest = elevatorController.getUpPendingRequest();
                    PendingRequests pr = upPendingRequest.poll();
                    elevatorController.getElevatorCar().move(pr.getDir(),pr.getFloor());
                    moveElevator(elevatorController);
                }
                else {
                    elevatorController.getElevatorCar().move(Direction.UP,elevatorController.getTopFloor());
                    elevatorController.getElevatorCar().setDir(Direction.DOWN);
                }
            }
            else {
                if(!elevatorController.getDownPendingRequest().isEmpty()){
                    PriorityQueue<PendingRequests> downPendingRequest = elevatorController.getDownPendingRequest();
                    PendingRequests pr = downPendingRequest.poll();
                    elevatorController.getElevatorCar().move(pr.getDir(),pr.getFloor());
                    moveElevator(elevatorController);
                }
                else {
                    elevatorController.getElevatorCar().move(Direction.DOWN,elevatorController.getBottomFloor());
                    elevatorController.getElevatorCar().setDir(Direction.UP);
                }

            }
        }

//        In this algorithm, elevator starts from one end of the disk and moves
//        towards the other end, servicing requests in between one by one and reach the other end.
//        Then the direction of the elevator is reversed and the process continues.

//        Implemented using two array
//        All floors with UP requests are marked in the UP array
//        and all floors with DOWN request are marked in the DOWN array
//        and the elevator scans UP array while moving up and DOWN array while moving down
//        and it stops at the requested floors

//        Advantage:
//        1. not frequent change of floor for every request
//        2. no starvation

//        Disadvantage: If there are 100 floors, and last requested floor in current direction
//        is 15, then also the elevator will move till the 100th floor.
//        This is improved by LOOK Algorithm

    }
}

