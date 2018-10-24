package edu.sdu.woz;

import edu.sdu.woz.facade.IFacade;
import edu.sdu.woz.facade.TextFacade;
import java.awt.Point;
import java.util.HashMap;

public class Game {
    private Room currentRoom;
    private final HashMap<Point, Room> map = new HashMap<>();
    private final IFacade facade;


    public Game(TextFacade tf) {
        facade = tf;
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
        facade.onRoomEnter(room);
    }
    
    public Room go(Direction direction){
        if (!currentRoom.canGo(direction)) { return null; }
        
        Point point = new Point(
            currentRoom.getPosition().x + direction.getDelta().x,
            currentRoom.getPosition().y + direction.getDelta().y );

        Room room = getRoom(point);
        enterRoom(room);
        return room;
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
