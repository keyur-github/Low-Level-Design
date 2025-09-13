package entity;

public class Command {

    private String request;
    private Integer floor;
    private Direction direction;

    public Command(String request, Integer floor, Direction direction) {
        this.request = request;
        this.floor = floor;
        this.direction = direction;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
