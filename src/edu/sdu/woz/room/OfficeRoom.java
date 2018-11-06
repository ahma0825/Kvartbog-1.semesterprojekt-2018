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
public class OfficeRoom extends Room {
    
    private boolean answered = false;
    
    public OfficeRoom(Game game, Point pos) {
        super(game, pos);
    }

    public String answer() {
        if (!answered){
            answered = true;
            return "You pick up the phone, put it to your ear and a spooky sound comes from the phone.";
        } else{
            return "You pick up the phone again and you hear another spooky sound.";
        }
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
