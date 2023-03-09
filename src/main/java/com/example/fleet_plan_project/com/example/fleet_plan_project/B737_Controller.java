package com.example.fleet_plan_project;

//Import Statements
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class B737_Controller {

    @FXML
    private Button exit;

    @FXML
    void exit() {
        new GeneralFunctions().close(exit);
    }
    }
