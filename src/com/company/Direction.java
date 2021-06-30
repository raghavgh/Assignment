package com.company;

public enum MovingDirection{
    AHEAD,RIGHT,LEFT
}
public enum FacingDirection{
    NORTH,SOUTH,EAST,WEST
}

public class Direction{
    MovingDirection movingDirection;
    FacingDirection facingDirection;
    public Direction(MovingDirection movingDirection,FacingDirection facingDirection){
        this.movingDirection = movingDirection;
        this.facingDirection = facingDirection;
    }

    public Step move(Integer x, Integer y, Integer units){
        switch (facingDirection){
            case NORTH:
                switch (movingDirection){
                    case LEFT :
                        x = x - units;
                        break;
                    case RIGHT:
                        y =y + units;
                        break;

                }
        }
    }
}
/*
    facing direction
    x coordinates and y coordinates

    North
        left
        ahead  x and y
 */
