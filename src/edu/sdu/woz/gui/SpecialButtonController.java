package edu.sdu.woz.gui;

import edu.sdu.woz.Direction;
import edu.sdu.woz.Game;
import javafx.scene.control.Button;

class SpecialButtonController {

    private Button specialButton;
    private Game game;
    private Runnable currentAction = null;

    SpecialButtonController(Button specialButton, Game game) {
        this.specialButton = specialButton;
        this.game = game;
        specialButton.setVisible(false);
    }

    void onClick() {
        currentAction.run();
    }

    void update() {
        if (game.getCurrentRoom().canGo(Direction.DOWN)) {
            specialButton.setVisible(true);
            specialButton.setText("Go down");
            currentAction = () -> game.go(Direction.DOWN);
            return;
        } else if (game.getCurrentRoom().canGo(Direction.UP)) {
            specialButton.setVisible(true);
            specialButton.setText("Go up");
            currentAction = () -> game.go(Direction.UP);
            return;
        }

        specialButton.setVisible(false);
        currentAction = null;
    }

}
