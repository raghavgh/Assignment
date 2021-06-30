package com.company;

public class Position {

    private Integer x;
    private Integer y;
    private FacingDirection facingDirection;

    public Position(Integer x, Integer y, FacingDirection facingDirection) {
        this.x = x;
        this.y = y;
        this.facingDirection = facingDirection;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

}
