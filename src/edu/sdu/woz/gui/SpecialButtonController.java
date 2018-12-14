package edu.sdu.woz.gui;

import edu.sdu.woz.Direction;
import edu.sdu.woz.Game;
import edu.sdu.woz.Item;
import edu.sdu.woz.room.OfficeRoom;
import edu.sdu.woz.room.RitualRoom;
import edu.sdu.woz.room.Room;
import javafx.scene.control.Button;

import java.util.function.Consumer;

class SpecialButtonController {

    private Button specialButton;
    private Consumer<String> println;
    private Game game;
    private Runnable currentAction = null;

    SpecialButtonController(Button specialButton, Game game, Consumer<String> println) {
        this.specialButton = specialButton;
        this.game = game;
        this.println = println;
        specialButton.setVisible(false);
    }

    void onClick() {
        currentAction.run();
    }

    void update() {
        Room room = game.getCurrentRoom();
        specialButton.setVisible(true);
        if (room.canGo(Direction.DOWN)) {
            specialButton.setText("Go down");
            currentAction = () -> game.go(Direction.DOWN);
        } else if (room.canGo(Direction.UP)) {
            specialButton.setText("Go up");
            currentAction = () -> game.go(Direction.UP);
        } else if (room instanceof OfficeRoom) {
            specialButton.setText("Answer phone");
            currentAction = () -> println.accept(((OfficeRoom) room).answer());
        } else if (room instanceof RitualRoom && game.getInventory().contains(Item.LIGHTER)) {
            specialButton.setText("Ignite");
            currentAction = () -> {
                println.accept(((RitualRoom) room).ignite());
                update();
            };
        } else {
            specialButton.setVisible(false);
            currentAction = null;
        }
    }

}
