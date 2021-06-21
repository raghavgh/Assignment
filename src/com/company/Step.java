package com.company;

import java.util.Iterator;

public class Step {
    public Step(Direction direction, Integer noOfMoves) {
        this.direction = direction;
        this.noOfMoves = noOfMoves;
        this.xDirection = 0;
        this.yDirection = 0;
        this.extraDistX = 0;
        this.extraDistY = 0;
        if (direction.equals(Direction.AHEAD)) {
            yDirection = noOfMoves;
            extraDistY = 1;
        } else if (direction.equals(Direction.LEFT)) {
            xDirection = (-1) * noOfMoves;
            extraDistX =  (-1);
        } else {
            xDirection = noOfMoves;
            extraDistX = 1;
        }
    }

    private Direction direction;
    private Integer noOfMoves;

    public void move(Coordinates start){
        Integer x = start.getX();
        Integer y = start.getY();
        x += xDirection;
        y += yDirection;
        start.setX(x);
        start.setY(y);
        Iterator<Coordinates> it = Main.holes.iterator();

        // Iterate HashSet with the help of hasNext() and
        // next() method
        for(Coordinates coordinates: Main.holes) {
            if(start.getX().equals(coordinates.getX()) && start.getY().equals(coordinates.getY())){
                x += extraDistX;
                y += extraDistY;
                break;
            }
        }
        start.setY(y);
        start.setX(x);
    }

    public Integer getxDirection() {
        return xDirection;
    }

    public Integer getyDirection() {
        return yDirection;
    }

    private Integer xDirection;
    private Integer yDirection;
    private Integer extraDistX;
    private Integer extraDistY;

    public Direction getDirection() {
        return direction;
    }

    public Integer getNoOfMoves() {
        return noOfMoves;
    }

}
