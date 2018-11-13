package edu.sdu.woz.room;

import edu.sdu.woz.Direction;
import edu.sdu.woz.Game;
import edu.sdu.woz.Item;

import java.awt.*;

import static edu.sdu.woz.text.Escapes.*;

public class GhostRoom extends Room {

    public GhostRoom(Game game, Point pos) {
        super(game, pos);
        items.add(Item.SHOTGUN);

    }

    @Override
    public String examine() {
        if (!game.isIgnited()) {
            return "There are weird markings on the door."
                    + "\nThe room is dusty, all the furniture is covered in white sheets and there's a shotgun on hanging on the wall. "
                    + "\nAs u step in the room, a ghost appears shouting "
                    + modes(BOLD, BG_YELLOW, FG_BLACK) + "THIS IS MY ROOM!" + RESET
                    + "\nYou get pushed out of the room, back into the office.";
        } else {
            return "The room is dusty and all the furniture is covered in white sheets. "
                    + "\nThere's a smiling " + modes(BG_BLUE) + "GHOST" + RESET + " handing you a sawed-off double barrel shotgun.";
        }
    }

    @Override
    public void afterEnter() {
        if (!game.isIgnited()) {
            game.go(Direction.SOUTH);
        }
    }

}
