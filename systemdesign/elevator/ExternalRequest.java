package elevator;

public class ExternalRequest {
    int sourceFloor;
    Direction directionToGo;

    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    public void setDirectionToGo(Direction directionToGo) {
        this.directionToGo = directionToGo;
    }

    public Direction getDirectionToGo() {
        return directionToGo;
    }
}
