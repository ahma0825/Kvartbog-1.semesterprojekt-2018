package edu.sdu.woz.text;

import edu.sdu.woz.Direction;
import edu.sdu.woz.Game;
import edu.sdu.woz.IFacade;
import edu.sdu.woz.Item;
import edu.sdu.woz.room.OfficeRoom;
import edu.sdu.woz.room.RitualRoom;
import edu.sdu.woz.room.Room;

import java.util.Arrays;
import java.util.List;

public class TextFacade implements IFacade {

    private Parser parser = new Parser();
    private Game game = new Game(this);

    public static void main(String[] args) {
        Escapes.setEnabled(true);

        for (String arg : args) {
            if (arg.equals("-noAnsi")) {
                Escapes.setEnabled(false);
            }
        }

        if (Escapes.isEnabled()) {
            System.out.println(Escapes.modes(Escapes.FG_BLUE) +
                    "ANSI escapes are enabled. If the text looks garbled," +
                    " use the '-noAnsi' argument to disable it." + Escapes.reset);
        }

        TextFacade tf = new TextFacade();
        tf.play();
    }

    private void play() {
        //printWelcome();

        println(Escapes.modes(Escapes.FG_RED, Escapes.BLINK, Escapes.BOLD, Escapes.UNDERSCORE)
                + "Welcome to the Manor Story" + Escapes.reset);
        println("Type \"dir\" for directions");
        println("Type \"help\" for more info");

        //noinspection InfiniteLoopStatement
        while (true) {
            Command command = parser.getCommand();
            processCommand(command);
        }
    }

    @Override
    public void onRoomEnter(Room room) {
        println(room.examine());
    }

    private void processCommand(Command command) {
        CommandWord commandWord = command.getCommandWord();
        if (commandWord == CommandWord.UNKNOWN) {
            println("I don't know what you mean...");
            return;
        }
        switch (commandWord) {
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
                break;
            case QUIT:
                quit();
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
            case IGNITE:
                ignite();
                break;
            case DIRECTIONS:
                println(getDirections());
                break;
        }
    }

    private void printHelp() {
        println("These are the commands that are available in this program:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        Direction dir;
        if (!command.hasSecondWord()) {
            println("Go command lacks second word");
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
            case "up":
                dir = Direction.UP;
                break;
            case "down":
                dir = Direction.DOWN;
                break;
            default:
                println("Command not understood. Please try again.");
                return;
        }

        if (!game.getCurrentRoom().canGo(dir)) {
            println("You can't go in that direction.");
            println("Available directions: " + getDirections());
            return;
        }

        game.go(dir);
    }

    private void quit() {
        println("Thank you for playing!");
        System.exit(0);
    }

    private void inventory() {
        List<Item> inv = game.getInventory();
        if (inv.isEmpty()) {
            println("My inventory is empty.");
        } else {
            println("I carry these items:");
            inv.forEach(System.out::println);
        }
    }

    private void take(Command command) {
        Item item = Item.parse(command.getSecondWord());
        if (item == null) {
            println("Take what?");
            return;
        }
        if (game.getCurrentRoom().takeItem(item)) {
            println("You took " + item.getDescription());
            game.getInventory().add(item);
        } else {
            println("There's no such item here");
        }
    }

    private void answer() {
        if (game.getCurrentRoom() instanceof OfficeRoom) {
            println(((OfficeRoom) game.getCurrentRoom()).answer());
        } else {
            println("I don't know what to answer.");
        }
    }

    private void ignite() {
        if (game.getCurrentRoom() instanceof RitualRoom) {
            println(((RitualRoom) game.getCurrentRoom()).ignite());
        } else {
            println("Can't do this.");
        }
    }

    private String getDirections() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Direction.values())
                .filter(dir -> game.getCurrentRoom().canGo(dir))
                .forEach(dir -> {
                    sb.append(dir.name().toLowerCase());
                    sb.append(", ");
                });

        return sb.substring(0, sb.length() - 2);
    }

    @Override
    public void onGameOver(boolean won) {
        println("GAME OVER");
        System.exit(0);
    }

    private void println(String x) {
        System.out.println(x);
    }

}
