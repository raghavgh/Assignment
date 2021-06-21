package com.company;

import java.util.*;

public class Main {

    static Set<Coordinates> holes;
    static List<Step> steps;
    static Coordinates start;
    public static void main(String[] args) {
	// write your code here
        holes = new HashSet<>();
        steps = new ArrayList<>();
        FileProcessor fileProcessor = new FileProcessor("input.txt");
        fileProcessor.processFile();
        Coordinates coordinates = getFinalCoordinates();
        System.out.println(coordinates.toString());
    }

    public static Coordinates getFinalCoordinates(){
        for(Step step: steps){
            step.move(start);
        }
        return start;
    }
}
