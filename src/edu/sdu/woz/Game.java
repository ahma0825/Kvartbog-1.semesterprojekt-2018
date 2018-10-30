package edu.sdu.woz;

import static edu.sdu.woz.Direction.EAST;
import edu.sdu.woz.facade.IFacade;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private Room currentRoom;
    private final HashMap<Point, Room> map = new HashMap<>();
    private final List<Item> inventory = new ArrayList<>();
    private final IFacade facade;

    public Game(IFacade tf) {
        facade = tf;

        // Entrance
        putRoom(new EmptyRoom(this, new Point(0,0),
                "You find yourself standing in a grand entrance. There's a hallway to the north."
        ));

        // End Room~
        putRoom(new EmptyRoom(this, new Point(-1,0),"End Room").setDirections(EAST));
        // Dining Room~
        putRoom(new EmptyRoom(this, new Point(1,0),"Dining Room"));
        // Room
        putRoom(new EmptyRoom(this, new Point(2,0),"Room"));
        // Kitchen~
        putRoom(new EmptyRoom(this, new Point(3,0),"Kitchen"));
        // Sideroom
        putRoom(new EmptyRoom(this, new Point(1,1),"SideRoom"));
        // Basement~
        putRoom(new EmptyRoom(this, new Point(-1,1),"Basement"));
        // Ghostroom~
        putRoom(new EmptyRoom(this, new Point(2,2),"Ghostroom"));
        // Office~
        putRoom(new EmptyRoom(this, new Point(2,1),"Office"));
        // Bathroom~
        putRoom(new EmptyRoom(this, new Point(2,-1),"Bathroom"));
        // Dark Room~
        putRoom(new EmptyRoom(this, new Point(3,1),"Dark Room"));
        // Dining Room
        putRoom(new EmptyRoom(this, new Point(3,-1),"Room"));
                
        currentRoom = map.get(new Point(0, 0));
        facade.onRoomEnter(currentRoom);
    }

    private void putRoom(Room room) {
        map.put(room.getPosition(), room);
    }

    public HashMap<Point, Room> getMap() {
        return map;
    }

    public Room getRoom(Point position) {
        return map.get(position);
    }

    public Room getRoom(int x, int y) {
        return getRoom(new Point(x, y));
    }

    public void enterRoom(Room room) {
        currentRoom = room;
        facade.onRoomEnter(room);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room go(Direction direction) {
        if (!currentRoom.canGo(direction)) {
            System.out.println("You can't go in this direction");
            return null;
        }

        Point point = new Point(
                currentRoom.getPosition().x + direction.getDelta().x,
                currentRoom.getPosition().y + direction.getDelta().y);

        Room room = getRoom(point);
        enterRoom(room);
        return room;
    }
}
