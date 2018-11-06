/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sdu.woz.room;

import edu.sdu.woz.Game;
import edu.sdu.woz.Item;
import java.awt.Point;

/**
 *
 * @author jesperisgaard
 */
public class KitchenRoom extends Room {

    public KitchenRoom(Game game, Point pos) {
        super(game, pos);
        items.add(Item.GARLIC);
    }

    @Override
    public String examine() {
        if(items.contains(Item.GARLIC)){
            return "There is a string of Garlic in this room."; //Needs better writing
        } else {
            return "There is no Garlic in this room."; //Needs better writing
        }
    }
    
    
    
}
