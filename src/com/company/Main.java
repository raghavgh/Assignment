package com.company;

import java.util.*;

public class Main {

    static Set<Coordinates> holes;
    static List<Step> steps;
    static Coordinates current;
    public static void main(String[] args) {

        holes = new HashSet<>();
        steps = new ArrayList<>();
        FileProcessor fileProcessor = new FileProcessor("input.txt");
        fileProcessor.processFile();
        Coordinates coordinates = getFinalCoordinates();
        System.out.println(coordinates.toString());
    }

    public static Coordinates getFinalCoordinates(){
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
        for(Coordinates coordinates: Main.holes) {
            if(current.getX().equals(coordinates.getX()) && current.getY().equals(coordinates.getY())){
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
