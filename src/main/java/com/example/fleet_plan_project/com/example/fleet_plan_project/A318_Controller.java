package com.example.fleet_plan_project;

//Import Statements
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class A318_Controller {
    @FXML
    private Button exit;

    @FXML
    public void exit() {
        new GeneralFunctions().close(exit);
    }
}
