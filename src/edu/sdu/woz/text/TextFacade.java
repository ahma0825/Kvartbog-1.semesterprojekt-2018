package edu.sdu.woz.text;

import edu.sdu.woz.Direction;
import edu.sdu.woz.Game;
import edu.sdu.woz.IFacade;
import edu.sdu.woz.Item;
import edu.sdu.woz.room.OfficeRoom;
import edu.sdu.woz.room.RitualRoom;
import edu.sdu.woz.room.Room;

import java.io.IOException;
import java.util.List;
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

        System.out.println(Escapes.modes(Escapes.FG_RED, Escapes.BLINK, Escapes.BOLD, Escapes.UNDERSCORE) + "Welcome to the Manor Story.");
        System.out.print(Escapes.RESET);

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye.");
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
        switch (commandWord) {
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
                break;
            case QUIT:
                quit(command);
                break;
            case INVENTORY:
                inventory();
                break;
            case TAKE:
                take(command);
                break;
            case ANSWER:
                answer();
                break;
        }
        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("These are the commands that are available in this program:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        Direction dir;
        if (!command.hasSecondWord()) {
            System.out.println("Go command lacks second word");
            return;
        }
        switch (command.getSecondWord()) {
            case "west":
            case "left":
                dir = Direction.WEST;
                break;
            case "north":
            case "forward":
                dir = Direction.NORTH;
                break;
            case "east":
            case "right":
                dir = Direction.EAST;
                break;
            case "south":
            case "backwards":
                dir = Direction.SOUTH;
                break;
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

    private void inventory() {
        List<Item> inv = game.getInventory();
        if (inv.isEmpty()) {
            System.out.println("My inventory is empty.");
        } else {
            System.out.println("I carry these items:");
            inv.forEach(System.out::println);
        }
    }

    private void take(Command command) {
        Item item = Item.parse(command.getSecondWord());
        if (item == null) {
            System.out.println("Take what?");
            return;
        }
        if (game.getCurrentRoom().takeItem(item)) {
            System.out.println("You took " + item.getDescription());
            game.getInventory().add(item);
        } else {
            System.out.println("There's no such item here");
        }
    }

    private void answer() {
        if (game.getCurrentRoom() instanceof OfficeRoom) {
            System.out.println(((OfficeRoom) game.getCurrentRoom()).answer());
        } else {
            System.out.println("I don't know what to answer.");
        }
    }
    
    private void ignite() {
        if (game.getCurrentRoom() instanceof RitualRoom) {
            System.out.println(((RitualRoom) game.getCurrentRoom()).ignite());
        } else {
            System.out.println("I don't have a lighter");
        }
    }
}
