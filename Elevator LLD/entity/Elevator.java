package entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Elevator {
    private Integer eid;
    private Integer minFloor;
    private Integer maxFloor;
    private Integer currentFloor;
    private State state;
    private Direction direction;
    private List<Request> requests;

    public Elevator(Integer eid, Integer minFloor, Integer maxFloor) {
        this.eid = eid;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.currentFloor = minFloor;
        this.state = State.STOPPED;
        this.direction = Direction.IDLE;
        this.requests = new ArrayList<>();
    }

    public void addRequests(Request request) {
        this.requests.add(request);
        this.requests.sort(Comparator.comparingInt(r -> Math.abs(r.getFloor() - this.currentFloor)));
    }

    public void step() {
        if(this.requests == null || this.requests.isEmpty()) {
            this.state = State.STOPPED;
            this.direction = Direction.IDLE;
            return;
        }
        int targetFloor = this.requests.getFirst().getFloor();
        if(targetFloor > this.currentFloor) {
            this.direction = Direction.UP;
            currentFloor++;
            this.state = State.MOVING;
        } else  if (targetFloor < this.currentFloor) {
            this.direction = Direction.DOWN;
            currentFloor--;
            this.state = State.MOVING;
        } else {
            openDoors();
            this.requests.removeFirst();
            if(this.requests != null && !this.requests.isEmpty()) {
                this.direction = Direction.IDLE;
            }
        }
    }

    private void openDoors() {
        this.state = State.DOOR_OPEN;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted :: " + e.getMessage());
        }
        if(this.requests == null || this.requests.isEmpty()) {
            this.state = State.STOPPED;
            this.currentFloor = this.minFloor;
        } else {
            this.state = State.MOVING;
        }
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getMinFloor() {
        return minFloor;
    }

    public void setMinFloor(Integer minFloor) {
        this.minFloor = minFloor;
    }

    public Integer getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(Integer maxFloor) {
        this.maxFloor = maxFloor;
    }
}
