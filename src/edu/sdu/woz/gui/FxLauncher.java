package edu.sdu.woz.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class FxLauncher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        
        stage.setMinWidth(640);
        stage.setMinHeight(480);
        stage.getIcons().add(new Image("/images/vampire.png"));
        stage.setTitle("Manor Story");
        stage.setScene(scene);
        stage.show();
    }
    
}
