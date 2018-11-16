package edu.sdu.woz.room;

import edu.sdu.woz.Game;
import edu.sdu.woz.Item;

import java.awt.*;

public class KitchenRoom extends Room {

    public KitchenRoom(Game game, Point pos) {
        super(game, pos);
        items.add(Item.GARLIC);
    }

    @Override
    public String examine() {
        if (items.contains(Item.GARLIC)) {
            return "You enter the kitchen, knives and plates are all over the place and covered in blood. "
                    + "\nThe only thing that isn't red is a string of garlic.";
        } else {
            return "You enter the kitchen, knives and plates are all over the place and covered in blood.";
        }
    }


}
