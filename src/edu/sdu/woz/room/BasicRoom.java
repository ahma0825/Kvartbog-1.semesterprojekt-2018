/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sdu.woz.room;

import edu.sdu.woz.Game;

import java.awt.*;

/**
 * @author jesperisgaard
 */
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
