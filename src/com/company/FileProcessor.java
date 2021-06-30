package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {
    File file;

    /**
     * Initialize file object
     * @param filePath path of file
     */
    public FileProcessor(String filePath) {
        this.file = new File(filePath);
    }

    /**
     * it process file take strings from file and process them
     */
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

    /**
     * it takes command ass a string and save into java objects according to it's nature
     * @param command input command need to process
     */
    public void processInputCommand(String command){
        String[] commandParams = command.split(" ");
        String str;
        switch (commandParams[0]){
            case "START":
                Main.current = new Position(Integer.parseInt(commandParams[1]),
                        Integer.parseInt(commandParams[2]));
                break;
            case "HOLE":
                Position position = new Position(Integer.parseInt(commandParams[1]),
                        Integer.parseInt(commandParams[2]));
                Main.holes.add(position);
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
