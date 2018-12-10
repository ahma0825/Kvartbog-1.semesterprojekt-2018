package edu.sdu.woz.gui;

import edu.sdu.woz.Direction;
import edu.sdu.woz.Game;
import edu.sdu.woz.IFacade;
import edu.sdu.woz.Item;
import edu.sdu.woz.room.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@SuppressWarnings("unused")
public class FxFacade implements Initializable, IFacade {

    private Game game = null;
    private SpecialButtonController specialButtonController = null;

    @FXML
    private Button specialButton;
    @FXML
    private TextArea terminal;
    @FXML
    private Button goNorth;
    @FXML
    private Button goSouth;
    @FXML
    private Button goWest;
    @FXML
    private Button goEast;
    @FXML
    private Button take;
    @FXML
    private ImageView item1;
    @FXML
    private ImageView item2;
    @FXML
    private ImageView item3;
    @FXML
    private ImageView item4;
    private final List<ImageView> availableSlots = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = new Game(this);
        specialButtonController = new SpecialButtonController(specialButton, game, this::println);
        availableSlots.add(item1);
        availableSlots.add(item2);
        availableSlots.add(item3);
        availableSlots.add(item4);
    }

    @FXML
    private void onSpecial(ActionEvent event) {
        specialButtonController.onClick();
    }

    @FXML
    private void onNorth(ActionEvent event) {
        game.go(Direction.NORTH);
    }

    @FXML
    private void onSouth(ActionEvent event) {
        game.go(Direction.SOUTH);
    }

    @FXML
    private void onWest(ActionEvent event) {
        game.go(Direction.WEST);
    }

    @FXML
    private void onEast(ActionEvent event) {
        game.go(Direction.EAST);
    }

    @FXML
    private void onTake(ActionEvent event) {
        Room room = game.getCurrentRoom();
        Item item = room.getItems().get(0);
        room.takeItem(item);
        game.getInventory().add(item);
        println("Took " + item.getDescription());
        specialButtonController.update();
        take.setDisable(true);
        availableSlots.remove(0).setImage(new Image(item.getImageUrl()));
    }

    @Override
    public void onRoomEnter(Room room) {
        println(room.examine());

        if (room.canGo(Direction.NORTH)) {
            goNorth.setDisable(false);
        } else {
            goNorth.setDisable(true);
        }

        if (room.canGo(Direction.SOUTH)) {
            goSouth.setDisable(false);
        } else {
            goSouth.setDisable(true);
        }

        if (room.canGo(Direction.WEST)) {
            goWest.setDisable(false);
        } else {
            goWest.setDisable(true);
        }

        if (room.canGo(Direction.EAST)) {
            goEast.setDisable(false);
        } else {
            goEast.setDisable(true);
        }

        take.setDisable(room.getItems().isEmpty());

        if (game != null) specialButtonController.update();
    }

    @Override
    public void onGameOver(boolean won) {
        Alert alert;
        if (won) {
            alert = new Alert(Alert.AlertType.INFORMATION, "You win!");
            alert.setHeaderText("Guess what?");
            alert.setTitle("Good news");
        } else {
            alert = new Alert(Alert.AlertType.ERROR, "Such misfortune");
            alert.setHeaderText("You are dead");
            alert.setTitle("Rest in pieces");
        }
        alert.setOnCloseRequest(__ -> System.exit(0));
        alert.show();
    }

    private void println(String s) {
        terminal.appendText(s + "\n");
    }

}
