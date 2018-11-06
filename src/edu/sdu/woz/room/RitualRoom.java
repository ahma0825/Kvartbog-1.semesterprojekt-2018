package edu.sdu.woz.room;

import edu.sdu.woz.Game;
import edu.sdu.woz.Item;
import java.awt.Point;

public class RitualRoom extends Room {

    private boolean ignited;

    public RitualRoom(Game game, Point pos) {
        super(game, pos);
        items.add(Item.ZIPPO);
    }

    @Override
    public String examine() {
        if (items.contains(Item.ZIPPO)) {
            return "You enter a dark room, there are weird markings on the wall and a Zippo lighter on the floor"
                    + "\nThere's a dead body covered in gasoline on what appears to be a sacrifice table";
        } else {
            return "There's a lot of smoke and some bones and ashes on the sacrifice table";
        }
    }

    public String ignite() {
        if (!ignited) {
            ignited = true;
            return "You flick the lighter and throw it at the body setting it ablaze.";
        } else {
            return "The lighter is gone";
        }
    }

}
