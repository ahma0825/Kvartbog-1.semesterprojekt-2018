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
public class EndRoom extends Room {

    public EndRoom(Game game, Point pos) {
        super(game, pos);
    }

    @Override
    public String examine() {
        return "You exit the Manor, you are free.";
    }

    @Override
    public void afterEnter() {
        game.gameOver();
    }

}
