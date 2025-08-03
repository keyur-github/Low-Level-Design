package controller;

import entity.Elevator;
import entity.Request;

import java.util.*;

public class ElevatorController {

    private final List<Elevator> elevators = new ArrayList<>();

    public ElevatorController(Integer numElevators, Integer minFloor, Integer maxFloor) {
        for(int i = 1; i <= numElevators; i++) {
            elevators.add(new Elevator(i, minFloor, maxFloor));
        }
    }

    public void requestElevator(Request request) {
        Elevator chosenElevator = Collections.min(
                elevators,
                Comparator.comparingInt(x -> Math.abs(x.getCurrentFloor()-request.getFloor()))
        );
        chosenElevator.addRequests(request);
    }

    public void processRequest() {

    }


}
