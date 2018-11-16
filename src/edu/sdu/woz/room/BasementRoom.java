/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sdu.woz.room;

import edu.sdu.woz.Game;
import edu.sdu.woz.Item;

import java.awt.*;

/**
 * @author jesperisgaard
 */
public class BasementRoom extends Room {

    public BasementRoom(Game game, Point pos) {
        super(game, pos);
        items.add(Item.KEY);
    }

    @Override
    public String examine() {
        if (items.contains(Item.KEY)) {
            if (!game.getInventory().contains(Item.GARLIC)) {
                return "The door is heavy and squeaky, there's a strong smell of iron in the air."
                        + "\nA VAMPIRE APPEARS!"
                        + "\nThe vampire jumps at you, bites your neck and starts drinking your blood."
                        + "\nYou end up motionless on the floor, dying as the vampire sucks the life from you.";
                //Insert game end
            } else {
                return "The door is heavy and squeaky, there's a strong smell of iron in the air."
                        + "\nA VAMPIRE APPEARS!"
                        + "\nThe vampire jumps for you, but is deterred by the garlic you're carrying."
                        + "\nIt turns into a bat and flies away, dropping a key onto the ground as its form shifts."
                        + "\nThe only way out of this basement is back up the stairs.";
                //Possibly remove vampire when walking in again
            }
        } else {
            return "You walk down into the basement again. "
                    + "\nIt's quite damp, but there's nothing down here.";
        }
    }

    @Override
    public void afterEnter() {
        if (!game.getInventory().contains(Item.GARLIC)) {
            game.gameOver();
        }
    }

}
