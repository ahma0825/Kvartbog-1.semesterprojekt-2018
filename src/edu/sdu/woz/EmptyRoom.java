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

    private String description;

    public EmptyRoom(Game game, Point pos, String description) {
        super(game, pos);
        this.description = description;
    }
    
    @Override
    public String examine(){
        return description;
    }
    
    
}
