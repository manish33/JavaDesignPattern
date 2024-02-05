package LLDQuestions.Lift.ControlStratergy;

import LLDQuestions.Lift.Direction;
import LLDQuestions.Lift.ElevatorCar;
import LLDQuestions.Lift.ElevatorController;
import LLDQuestions.Lift.PendingRequests;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestSeekTime implements ElevatorControlStrategy {

    public void moveElevator(ElevatorController elevatorController)
    {
        if(!elevatorController.getPendingRequestList().isEmpty()){
            ElevatorCar elevatorCar = elevatorController.getElevatorCar();
            int currentFloor = elevatorCar.getCurrentFloor();

            Queue<PendingRequests> pendingRequestList = elevatorController.getPendingRequestList();

            PriorityQueue<PendingRequests> lessDistance = new PriorityQueue<PendingRequests>((p1,p2)->Integer.compare(Math.abs(p1.getFloor()-currentFloor),Math.abs(p2.getFloor()-currentFloor)));

            while (!pendingRequestList.isEmpty()){
                PendingRequests pr = pendingRequestList.poll();
                lessDistance.add(pr);
            }

            if(!lessDistance.isEmpty()){
                PendingRequests lessDistancePr = lessDistance.poll();
                if(lessDistancePr.getFloor()>currentFloor){
                    elevatorCar.setDir(Direction.UP);
                    elevatorCar.move(Direction.UP,lessDistancePr.getFloor());
                }
                else {
                    elevatorCar.setDir(Direction.DOWN);
                    elevatorCar.move(Direction.DOWN,lessDistancePr.getFloor());
                }
                moveElevator(elevatorController);

            }
        }

        //implemented using min heap which is sorted according to
        //min distance of requested floor from the current floor of elevator

        //this min heap is updated everytime a new request is added in the queue or
        // when elevator moves to another floor

        //Disadvantage: starvation of distant floor when maximum request keeps comes from nearly floors


    }
}
