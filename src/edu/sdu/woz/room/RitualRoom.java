package edu.sdu.woz.room;

import edu.sdu.woz.Game;
import edu.sdu.woz.Item;
import static edu.sdu.woz.text.Escapes.GO_SCARY;
import java.awt.Point;

public class RitualRoom extends Room {

    public RitualRoom(Game game, Point pos) {
        super(game, pos);
        items.add(Item.LIGHTER);
    }

    @Override
    public String examine() {
        if (items.contains(Item.LIGHTER)) {
            return "You enter a dark room, there are weird markings on the wall and a Zippo lighter on the floor."
                    + "\nThere's a dead body covered in gasoline on what appears to be a sacrifice table.";
        } else if (!game.isIgnited()){
            return "You enter a dark room, there are weird markings on the wall."
                    + "\nThere's a dead body covered in gasoline on what appears to be a sacrifice table.";
        } else {
            return "There's a lot of smoke and some bones and ashes on the sacrifice table.";
        }
    }
    
    public String ignite() {
        if (!game.isIgnited() && !items.contains(Item.LIGHTER)) {
            game.setIgnited(true);
            game.getInventory().remove(Item.LIGHTER);
            return "You flick the lighter and throw it at the body setting it" + GO_SCARY +  " ABLAZE!";
        } else {
            return "You don't have a lighter.";
        }
    }

}
