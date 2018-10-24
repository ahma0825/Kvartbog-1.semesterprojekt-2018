package edu.sdu.woz;

import java.awt.Point;

public abstract class Room {
    private final Game game;
    private final Point pos;

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
        Point point = new Point(
                pos.x + direction.getDelta().x,
                pos.y + direction.getDelta().y );
        
        return game.getRoom(point) != null;
    }
    
    
}
