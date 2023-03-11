package com.example.fleet_plan_project;

//Import Statements
import com.example.fleet_plan_project.model_Classes.Flight;
import com.example.fleet_plan_project.model_Classes.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class A318_Controller {
    @FXML
    private Button exit;

    Flight flight;

    @FXML
    public void exit() {
        new GeneralFunctions().close(exit);
    }

    public void userInfoForm(ActionEvent e) throws IOException {
        if(UserInfo_Controller.seatCount != Integer.parseInt(MainScreen_Controller.getNoOf_Tickets())){
            new GeneralFunctions().switchSceneModality  ("UserInfo.fxml");
            Button tmp = (Button) e.getTarget();
            tmp.setText("X");
            tmp.setOpacity(0.1);
        }
        else {
            new GeneralFunctions().switchSceneModality("Warning.fxml");
        }
    }
    public void done(ActionEvent e) throws IOException {
        if(UserInfo_Controller.seatCount == Integer.parseInt(MainScreen_Controller.getNoOf_Tickets())){
            flight = new Flight(FlightInfo_Controller.departureFlight,UserInfo_Controller.person,FlightInfo_Controller.returnFlight);
            System.out.print(flight);
            new GeneralFunctions().switchScene(e,"Farewell.fxml");
        }
        else if (UserInfo_Controller.seatCount != Integer.parseInt(MainScreen_Controller.getNoOf_Tickets())){
            new GeneralFunctions().switchSceneModality("Warning2.fxml");
        }
    }


}
