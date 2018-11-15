package edu.sdu.woz.room;

import edu.sdu.woz.Direction;
import static edu.sdu.woz.Direction.*;
import edu.sdu.woz.Game;
import edu.sdu.woz.Item;
import static edu.sdu.woz.Item.KEY;
import static edu.sdu.woz.Item.SHOTGUN;
import static edu.sdu.woz.text.Escapes.*;
import java.awt.Point;

public class EntranceRoom extends Room {

    private boolean werewolfKilled = false;

    public EntranceRoom(Game game, Point pos) {
        super(game, pos);
    }

    @Override
    public String examine() {
        if (werewolfKilled == false) {
            if (game.getInventory().contains(KEY) && game.getInventory().contains(SHOTGUN)) {
                werewolfKilled = true;
                return "You enter the grand entrance there's something different."
                        + "Two yellow glowing eyes appear in the dark corner of the room."
                        + "\nSuddenly a " + GO_SCARY + "WEREWOLF " + RESET + "jumps out at you!"
                        + "\nYou whip out the trusted double barrel shotgun and blow it to smithereens.";
            } else if (game.getInventory().contains(KEY) && !game.getInventory().contains(SHOTGUN)) {
                return "You enter the grand entrance there's something different."
                        + "\nTwo yellow glowing eyes appear in the dark corner of the room."
                        + "\nSuddenly a " + GO_SCARY + "WEREWOLF " + RESET + "jumps out at you!"
                        + "\nIt rips you apart!";
            } else {
                return "You find yourself standing in a grand entrance."
                        + "\nThere's an exit to the west, but it appears to be locked.";
            }
        } else {
            return "You stand in a grand entrance with a door to the west leading to your freedom." 
                    + "\nOn the floor lies the remains of what was once a werewolf.";
        }
    }

    @Override
    public void afterEnter() {
        if (!game.getInventory().contains(Item.SHOTGUN) && game.getInventory().contains(KEY)) {
            game.gameOver();
        }
    }

    @Override
    public boolean canGo(Direction direction) {
        if (direction == WEST && !game.getInventory().contains(KEY)) {
            return false;
        }

        return super.canGo(direction);
    }

}
