package edu.sdu.woz.room;

import edu.sdu.woz.Game;
import edu.sdu.woz.Item;
import static edu.sdu.woz.Item.KEY;
import static edu.sdu.woz.Item.SHOTGUN;
import static edu.sdu.woz.text.Escapes.GO_SCARY;
import static edu.sdu.woz.text.Escapes.RESET;
import java.awt.Point;

public class EntranceRoom extends Room {

    public EntranceRoom(Game game, Point pos) {
        super(game, pos);
    }

    @Override
    public String examine() {
        if (game.getInventory().contains(KEY) && game.getInventory().contains(SHOTGUN)) {
            return "You enter the grand entrance there's something different."
                    + "Two yellow glowing eyes appear in the dark corner of the room."
                    + "\nSuddenly a " + GO_SCARY + "WEREWOLF jumps out at you!"
                    + "\nYou whip out the trusted double barrel shotgun and blow it to smithereens";
        } else if (game.getInventory().contains(KEY) && !game.getInventory().contains(SHOTGUN)){
            return "You enter the grand entrance there's something different."
                    + "\nTwo yellow glowing eyes appear in the dark corner of the room."
                    + "\nSuddenly a " + GO_SCARY + "WEREWOLF " + RESET + "jumps out at you!"
                    + "\nIt rips you apart!";
        } else {
            return "You find yourself standing in a grand entrance";
        }
    }

}
