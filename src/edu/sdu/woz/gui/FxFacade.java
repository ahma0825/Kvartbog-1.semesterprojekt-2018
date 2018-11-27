/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sdu.woz.gui;

import edu.sdu.woz.Game;
import edu.sdu.woz.IFacade;
import edu.sdu.woz.room.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

@SuppressWarnings("unused")
public class FxFacade implements Initializable, IFacade {
    private Game game = null;
    @FXML
    private Button specialButton;
    @FXML
    private Text terminal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = new Game(this);
    }    

    @FXML
    private void onSpecial(ActionEvent event) {
    }

    @FXML
    private void onNorth(ActionEvent event) {
        
    }

    @FXML
    private void onSouth(ActionEvent event) {
    }

    @FXML
    private void onWest(ActionEvent event) {
    }

    @FXML
    private void onEast(ActionEvent event) {
    }

    @Override
    public void onRoomEnter(Room room) {
        terminal.setText(terminal.getText() + room.examine() + "\n");
    }

    @Override
    public void onGameOver() {

    }
}
