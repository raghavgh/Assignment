package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {
    File file;
    public FileProcessor(String filePath) {
        this.file = new File(filePath);
    }
    public void processFile(){
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String command = sc.nextLine();
                processInputCommand(command);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!! Please check the file and the location provided!");
        }
    }
    public void processInputCommand(String command){
        String[] commandParams = command.split(" ");
        String str;
        switch (commandParams[0]){
            case "START":
                Main.start = new Coordinates(Integer.parseInt(commandParams[1]),
                        Integer.parseInt(commandParams[2]));
                break;
            case "HOLE":
                Coordinates coordinates = new Coordinates(Integer.parseInt(commandParams[1]),
                        Integer.parseInt(commandParams[2]));
                Main.holes.add(coordinates);
                break;
            case "AHEAD":
                Step step = new Step(Direction.AHEAD,
                        Integer.parseInt(commandParams[1]));
                Main.steps.add(step);
                break;
            case "RIGHT":
                step = new Step(Direction.RIGHT,
                        Integer.parseInt(commandParams[1]));
                Main.steps.add(step);
                break;
            case "LEFT":
                step = new Step(Direction.LEFT,
                        Integer.parseInt(commandParams[1]));
                Main.steps.add(step);
                break;
        }
    }

}
