package com.example.fleet_plan_project;

//Import Statements
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class GeneralFunctions {
    LoadingScreen_Controller obj = new LoadingScreen_Controller(); //Initialized an Object to reuse previously declared Stages and Scenes

    //A General Method with Implements the functionality of Scene Switching
    public  void switchScene(Event e, String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        obj.stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        obj.scene = new Scene(fxmlLoader.load());
        obj.stage.setScene(obj.scene);
        obj.stage.centerOnScreen();
        obj.stage.show();
    }
    //A Function to Close the Application
    public void close(Button b){
        obj.stage = (Stage) b.getScene().getWindow();
        obj.stage.close();
    }

}
