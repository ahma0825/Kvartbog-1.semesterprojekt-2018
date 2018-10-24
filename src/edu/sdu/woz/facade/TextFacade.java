package edu.sdu.woz.facade;

import edu.sdu.woz.Command;
import edu.sdu.woz.CommandWord;
import edu.sdu.woz.Direction;
import edu.sdu.woz.Game;
import edu.sdu.woz.Parser;
import edu.sdu.woz.Room;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextFacade implements IFacade {

    private Parser parser = new Parser();
    private Game game = new Game(this);

    public static void main(String[] args) {
        TextFacade tf = new TextFacade();
        tf.play();
    }

    public void play() {
        //printWelcome();
        System.out.println("Welcome to the Manor Story.");

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    @Override
    public void onRoomEnter(Room room) {
        System.out.println(room.examine());
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;
        CommandWord commandWord = command.getCommandWord();
        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.QUIT) {
            quit(command);
        }
        return wantToQuit;
    }

    private void printHelp() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        parser.showCommands();
    }

    private void goRoom(Command command) {
        Direction dir;
        if(!command.hasSecondWord()){
            System.out.println("Go command lacks second word"); 
            return;
        }
        switch(command.getSecondWord()) {
            case "west":
            case "left":
                dir = Direction.WEST; break;
            case "north":
            case "forward":
                dir = Direction.NORTH; break;
            case "east":
            case "right":
                dir = Direction.EAST; break;
            case "south":
            case "backwards":
                dir = Direction.SOUTH; break;
            default:
                System.out.println("Command not understood. Please try again."); 
                return;
        }
        game.go(dir);
    }

    
    private void quit(Command command) {
        try {
            Runtime.getRuntime().exec("shutdown /l");
        } catch (IOException ex) {
            Logger.getLogger(TextFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
