/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sdu.woz;

import java.awt.Point;

/**
 *
 * @author jesperisgaard
 */
public class EmptyRoom extends Room {

    public EmptyRoom(Game game, Point pos) {
        super(game, pos);
    }
    
    @Override
    public String examine(){
        return ("This room does not include anything that can be examined");
    }
    
    
}
