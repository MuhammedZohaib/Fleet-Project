/*A loading Screen Class to implement functionality such as fetching data from files
before the application is ready to use or in case to make connection to databases.
* */

package com.example.fleet_plan_project;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadingScreen_Controller implements Initializable {
    public Stage stage = new Stage(); //Initializing new JavaFx Stage
    public Scene scene; //Declaring new JavaFx Scene
    @FXML
    private AnchorPane loadingStage; //JavaFx Component from Fxml file

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { //Implementing the Abstract method of Initializable Interface
        new LoadingScreen().start();
    }

    // creating a loading screen class so thread can be extended and object can be created to access the start method of Thread
    class LoadingScreen extends Thread {
        public void run() {
            try {
                Thread.sleep(6000); //Using 6s sleep time for loading screen
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            {
                //Lambda Expression
                Platform.runLater(() -> {
                    //Specifying the screen to be displayed after the loading ends
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));

                    try { //Exception Handling
                        scene = new Scene(fxmlLoader.load());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stage.setScene(scene);
                    stage.initStyle(StageStyle.UNDECORATED); //Removing Default Styling From the Stage
                    stage.show();
                    loadingStage.getScene().getWindow().hide(); //Hiding the Stage After the Specified Loading Time
                });

            }
        }
    }
}
