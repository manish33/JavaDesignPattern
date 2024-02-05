package LLDQuestions.Lift;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorController {

    private int id;
    private int topFloor;
    private int bottomFloor;
    private ElevatorCar elevatorCar;

    private Queue<PendingRequests> pendingRequestList= new LinkedList<PendingRequests>();
    private PriorityQueue<PendingRequests> upPendingRequest = new PriorityQueue<>((p1,p2)->Integer.compare(p1.getFloor(), p2.getFloor()));
    private PriorityQueue<PendingRequests> downPendingRequest = new PriorityQueue<>((p1,p2)->Integer.compare(p2.getFloor(), p1.getFloor()));

    public PriorityQueue<PendingRequests> getUpPendingRequest() {
        return upPendingRequest;
    }

    public void setUpPendingRequest(PriorityQueue<PendingRequests> upPendingRequest) {
        this.upPendingRequest = upPendingRequest;
    }

    public PriorityQueue<PendingRequests> getDownPendingRequest() {
        return downPendingRequest;
    }

    public void setDownPendingRequest(PriorityQueue<PendingRequests> downPendingRequest) {
        this.downPendingRequest = downPendingRequest;
    }

    public Queue<PendingRequests> getPendingRequestList() {
        return pendingRequestList;
    }

    public void setPendingRequestList(Queue<PendingRequests> pendingRequestList) {
        this.pendingRequestList = pendingRequestList;
    }

    public ElevatorController(int id)
    {
        this.id= id;
        elevatorCar= new ElevatorCar(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public void setElevatorCar(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }

    public int getTopFloor() {
        return topFloor;
    }

    public void setTopFloor(int topFloor) {
        this.topFloor = topFloor;
    }

    public int getBottomFloor() {
        return bottomFloor;
    }

    public void setBottomFloor(int bottomFloor) {
        this.bottomFloor = bottomFloor;
    }

    public void acceptRequest(int floor, Direction dir)
    {
        PendingRequests pr = new PendingRequests(floor, dir);
        if (pr.getDir() == Direction.UP) {
            upPendingRequest.add(pr);
        } else {
            downPendingRequest.add(pr);
        }

        getPendingRequestList().add(pr);
        controlCar();
    }
    private void controlCar()
    {

        ElevatorSystem.elevatorControlStrategy.moveElevator(this);
        System.out.println("Elevator moving...");
    }

}

