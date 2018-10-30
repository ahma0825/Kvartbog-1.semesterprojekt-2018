package edu.sdu.woz.facade;

import edu.sdu.woz.Command;
import edu.sdu.woz.CommandWords;

import java.util.Scanner;

public class Parser {
    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine().trim();

        switch (inputLine) {
            case "n":
            case "north":
                inputLine = "go north";
                break;
            case "w":
            case "west":
                inputLine = "go west";
                break;
            case "s":
            case "south":
                inputLine = "go south";
                break;
            case "e":
            case "east":
                inputLine = "go east";
                break;
            case "inv":
                inputLine = "inventory";
                break;
        }

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }

    public void showCommands() {
        commands.showAll();
    }
}
