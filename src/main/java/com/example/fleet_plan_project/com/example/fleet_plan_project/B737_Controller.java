package com.example.fleet_plan_project;

//Import Statements
import com.example.fleet_plan_project.model_Classes.Flight;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class B737_Controller implements Initializable {

    Flight flight;

    @FXML
    private Button exit;

    public static ArrayList<Button> reservedSeats = new ArrayList<>();
    Button[] seats = reservedSeats.toArray(new Button[0]);
    ArrayList<String> seatIds = new ArrayList<>();

    @FXML
    void exit() {
        new GeneralFunctions().close(exit);
    }

    public void userInfoForm(ActionEvent e) throws IOException {
        if(UserInfo_Controller.seatCount != Integer.parseInt(MainScreen_Controller.getNoOf_Tickets())){
            new GeneralFunctions().switchSceneModality  ("UserInfo.fxml");
            Button tmp = (Button) e.getTarget();
            tmp.setText("X");
            tmp.setOpacity(0.1);
            seatIds.add(((Button) e.getTarget()).getId());
            Button seat = new Button();
            seat.setText(tmp.getText());
            seat.setId(tmp.getId());
            seat.setStyle(tmp.getStyle());
            seat.setOpacity(tmp.getOpacity());
            reservedSeats.add(seat);
        }
        else {
            new GeneralFunctions().switchSceneModality("Warning.fxml");
        }
    }
    public void done(ActionEvent e) throws IOException {
        if(UserInfo_Controller.seatCount == Integer.parseInt(MainScreen_Controller.getNoOf_Tickets())){
            flight = new Flight(FlightInfo_Controller.departureFlight,UserInfo_Controller.person,FlightInfo_Controller.returnFlight,seatIds);
            new GeneralFunctions().reserveData(flight);
            new GeneralFunctions().switchScene(e,"Farewell.fxml");
            System.out.println(reservedSeats);
        }
        else if (UserInfo_Controller.seatCount != Integer.parseInt(MainScreen_Controller.getNoOf_Tickets())){
            new GeneralFunctions().switchSceneModality("Warning2.fxml");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(GeneralFunctions.showReservedSeats());
    }
}
