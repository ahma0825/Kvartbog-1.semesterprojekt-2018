package edu.sdu.woz;

import edu.sdu.woz.room.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static edu.sdu.woz.Direction.*;
import static edu.sdu.woz.text.Escapes.GO_SCARY;
import static edu.sdu.woz.text.Escapes.RESET;

public class Game {

    private Room currentRoom;
    private final HashMap<Point, Room> map = new HashMap<>();
    private final List<Item> inventory = new ArrayList<>();
    private final IFacade facade;
    private boolean ignited;

    public Game(IFacade tf) {
        facade = tf;

        // Entrance
        putRoom(new BasicRoom(this, new Point(0, 0),
                "You find yourself standing in a grand entrance."
        ).setDirections(EAST, WEST));
        // End Room~
        putRoom(new BasicRoom(this, new Point(-1, 0), "You exit the mansion, you are free!").setDirections(EAST));
        // Dining Room
        putRoom(new BasicRoom(this, new Point(1, 0),
                "You enter a dining hall, there's a feast going on. " +
                        "\nAll the participants are " + GO_SCARY + "SKELETONS" + RESET
        ).setDirections(NORTH, EAST, WEST, DOWN));
        // Room
        putRoom(new BasicRoom(this, new Point(2, 0), "This room is empty").setDirections(EAST, SOUTH, WEST));
        // Kitchen~
        putRoom(new KitchenRoom(this, new Point(3, 0)).setDirections(NORTH, SOUTH, WEST));
        // Sideroom
        putRoom(new BasicRoom(this, new Point(1, 1), "This room is empty").setDirections(EAST, SOUTH));
        // Basement~
        putRoom(new BasementRoom(this, new Point(1, -1)).setDirections(UP));
        // Ghostroom~
        putRoom(new GhostRoom(this, new Point(2, 2)).setDirections(SOUTH));
        // Office~
        putRoom(new OfficeRoom(this, new Point(2, 1)).setDirections(NORTH, EAST, WEST));
        // Bathroom~
        putRoom(new BasicRoom(this, new Point(2, -1), "You have entered the bathroom. "
                + "\nThe bathtub is filled with blood. "
                + "\nThere’s a mirror. When looked at it, it will show the back of your head. ").setDirections(NORTH, EAST));
        // Darkroom~
        putRoom(new BasicRoom(this, new Point(3, 1), "BATS fly out as you enter and the room is dark, moist and covered in cobwebs").setDirections(SOUTH, WEST));
        // Ritualroom~
        putRoom(new RitualRoom(this, new Point(3, -1)).setDirections(NORTH, WEST));

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

    public boolean isIgnited() {
        return ignited;
    }

    public void setIgnited(boolean ignited) {
        this.ignited = ignited;
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
