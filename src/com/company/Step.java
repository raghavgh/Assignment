package com.company;

import java.util.Iterator;

public class Step {
    private Integer xDirection;
    private Integer yDirection;
    private Integer extraDistX;
    private Integer extraDistY;
    private Direction direction;
    private Integer noOfMoves;

    /**
     * Initialize step with direction and number of moves
     * and also set units to move in x and y direction and
     * extra moves in case of hole encounters
     * @param direction indicating where to move
     * @param noOfMoves indicating amount of unit to move
     */
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
    public Integer getxDirection() {
        return xDirection;
    }

    public Integer getyDirection() {
        return yDirection;
    }

    public Direction getDirection() {
        return direction;
    }

    public Integer getNoOfMoves() {
        return noOfMoves;
    }
    public Integer getExtraDistX() {
        return extraDistX;
    }

    public Integer getExtraDistY() {
        return extraDistY;
    }

}
