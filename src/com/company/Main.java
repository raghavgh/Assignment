package com.company;

import java.util.*;

public class Main {

    static Set<Position> holes;
    static List<Step> steps;
    static Position current;

    public static void main(String[] args) {

        holes = new HashSet<>();
        steps = new ArrayList<>();
        FileProcessor fileProcessor = new FileProcessor("input.txt");
        fileProcessor.processFile();
        Position position = getFinalCoordinates();
        System.out.println(position.toString());
    }

    public static Position getFinalCoordinates(){
        for(Step step: steps){
            move(step);
        }
        return current;
    }

    /**
     * it update current coordinates according to step
     * @param step it contains information where to move and how much we need to move
     */
    public static void move(Step step){
        Integer x = current.getX();
        Integer y = current.getY();
        x += step.getxDirection();
        y += step.getyDirection();
        current.setX(x);
        current.setY(y);

        //it checks weather current coordinate is hole or not
        for(Position position : Main.holes) {
            if(current.getX().equals(position.getX()) && current.getY().equals(position.getY())){
                //if it found that current coordinate is hole then it updates to it's adjacent point
                x += step.getExtraDistX();
                y += step.getExtraDistY();
                break;
            }
        }
        current.setY(y);
        current.setX(x);
    }

}
