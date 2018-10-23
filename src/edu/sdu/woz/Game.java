package edu.sdu.woz;

import java.awt.Point;
import java.util.HashMap;

public class Game {
    private Parser parser;
    private Room currentRoom;
    private final HashMap<Point, Room> map = new HashMap<>();


    public Game() {
        parser = new Parser();
    }

    public HashMap<Point, Room> getMap() {
        return map;
    }
    
    public Room getRoom(Point position){
        return map.get(position);
    }
    
    public Room getRoom(int x, int y){
        return getRoom(new Point(x, y));
    } 
    
    public void enterRoom(Room room){
        currentRoom = room;
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
