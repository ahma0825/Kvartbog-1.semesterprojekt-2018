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
    }

    @Override
    public String examine() {
        if (!game.getInventory().contains(Item.GARLIC)){
            return "The door is heavy and squeaky, there's a strong smell of iton in the air." 
                    +"\nA VAMPIRE APPEARS!"
                    +"\nThe vampire jumps at you, bites your neck and starts drinking your blood."
                    +"\nYou end up motionless on the floor, dying as the vampire sucks the life from you.";
        } else{
            return "The door is heavy and squeaky, there's a strong smell of iton in the air." 
                    +"\nA VAMPIRE APPEARS!"
                    +"\nThe vampire jumps for you, but is deterred by the garlic you're carrying."
                    +"\nIt turns into a bat and flies away, revealing a small chest it was hiding."
                    +"\nThe only way out of this basement is back north, up the stairs.";
        }
    }

}
