package edu.sdu.woz.room;

import edu.sdu.woz.Direction;
import edu.sdu.woz.Game;
import edu.sdu.woz.Item;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.sdu.woz.Direction.*;

public abstract class Room {
    private final Game game;
    private final Point pos;
    private final List<Item> items = new ArrayList<>();
    private List<Direction> allowedDirections = Arrays.asList(NORTH, SOUTH, EAST, WEST);

    public Room(Game game, Point pos) {
        this.game = game;
        this.pos = pos;
    }

    public Game getGame() {
        return game;
    }

    public Point getPosition() {
        return pos;
    }
    
    public abstract String examine();

    public boolean canGo(Direction direction){
        if (!allowedDirections.contains(direction)) return false;

        Point point = new Point(
                pos.x + direction.getDelta().x,
                pos.y + direction.getDelta().y );

        return game.getRoom(point) != null;
    }

    public List<Item> getItems() {
        return items;
    }

    /** Returns true if the item was taken */
    public boolean takeItem(Item item) {
        return items.remove(item);
    }

    public Room setDirections(Direction... directions) {
        allowedDirections = Arrays.asList(directions);
        return this;
    }
}
