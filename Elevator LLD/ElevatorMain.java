import controller.ElevatorController;
import entity.Command;
import entity.Direction;

import java.util.List;

public class ElevatorMain {
    public static void main(String[] args) {
        System.out.println("Elevator Application Started");

        ElevatorController elevatorController = new ElevatorController(2, 1, 10);
        elevatorController.processRequest(
                List.of(
                        new Command("REQUESTS", 3, Direction.UP),
                        new Command("REQUESTS", 7, Direction.DOWN),
                        new Command("REQUESTS", 5, Direction.UP)
                )
        );
        System.out.println(elevatorController.getElevatorFloor(1));
//        System.out.println(elevatorController.getElevatorFloor(2));
        System.out.println(elevatorController.getElevatorState(1));
//        System.out.println(elevatorController.getElevatorState(2));
        System.out.println(elevatorController.getElevatorDirection(1));
//        System.out.println(elevatorController.getElevatorDirection(2));


    }
}
