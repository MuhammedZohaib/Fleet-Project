package com.example.fleet_plan_project;

//Import Statements
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class Main extends Application { //Execution Point of JavaFX Application
    @Override
    public void start(Stage stage) throws IOException {
        //Loading FXML File
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("B737.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene); //Setting Scene
        stage.initStyle(StageStyle.UNDECORATED); //Resetting Default Styling of Stage
        stage.show(); //Showing Stage
    }

    public static void main(String[] args) {
        launch();
    } //Main Method
}