package edu.sdu.woz;

public class Game {
    private Parser parser;
    private Room currentRoom;


    public Game() {
        parser = new Parser();
    }

    public void play() {
        //printWelcome();


        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            //finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
