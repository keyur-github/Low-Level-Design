package controller;

import entity.*;

import java.util.*;

public class ElevatorController {

    private final List<Elevator> elevators = new ArrayList<>();

    public ElevatorController(Integer numElevators, Integer minFloor, Integer maxFloor) {
        for(int i = 1; i <= numElevators; i++) {
            elevators.add(new Elevator(Integer.valueOf(i), minFloor, maxFloor));
        }
    }

    public void requestElevator(Request request) {
        Elevator chosenElevator = Collections.min(
                elevators,
                Comparator.comparingInt(x -> Math.abs(x.getCurrentFloor()-request.getFloor()))
        );
        chosenElevator.addRequests(request);
    }

    public void stepAll() {
        for (Elevator elevator : elevators) {
            elevator.step();
        }
    }

    public void processRequest(List<Command> commands) {
        for(Command command : commands) {
            if(command.getRequest().equalsIgnoreCase("REQUESTS")) {
                 this.requestElevator(new Request(command.getFloor(), command.getDirection()));
            }
        }
        while (this.elevators.stream().anyMatch(elevator -> !elevator.getRequests().isEmpty())) {
            this.stepAll();
        }
    }

    public Integer getElevatorFloor(Integer eId) {
        return this.elevators.get(eId-1).getCurrentFloor();
    }

    public State getElevatorState(Integer eId) {
        return this.elevators.get(eId-1).getState();
    }

    public Direction getElevatorDirection(Integer eId) {
        return this.elevators.get(eId-1).getDirection();
    }

}
