/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sdu.woz.room;

import edu.sdu.woz.Game;
import edu.sdu.woz.Item;

import java.awt.*;

import static edu.sdu.woz.text.Escapes.*;

/**
 * @author jesperisgaard
 */
public class GhostRoom extends Room {

    public GhostRoom(Game game, Point pos) {
        super(game, pos);
        items.add(Item.SHOTGUN);

    }

    @Override
    public String examine() {
        if(items.contains(Item.SHOTGUN)){  
            return "You have entered the ghostroom. "  
                    +"\nAs u step in the room, a ghost will appear shouting "
                    + modes(BOLD, BG_MAGENTA, FG_BLACK) + "THIS IS MY ROOM!" + RESET + ". "
                    +"\nshortly after the shoutning the ghost will disappear. "
                    +"\nYou must pick up the shotgun that is placed in the corner of the room";
        } else {
            return "There is no Shotgun in this room."; //Needs better writing
        }
    }
    
    
    
}
