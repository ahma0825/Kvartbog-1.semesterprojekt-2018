package edu.sdu.woz.room;

import edu.sdu.woz.Game;

import java.awt.*;


public class BasicRoom extends Room {

    private String description;

    public BasicRoom(Game game, Point pos, String description) {
        super(game, pos);
        this.description = description;
    }

    @Override
    public String examine() {
        return description;
    }

}
