package com.example.fleet_plan_project;

//Import Statements

import com.example.fleet_plan_project.model_Classes.Flight;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class A318_Controller implements Initializable {
    @FXML
    private Button exit;
    @FXML
    private AnchorPane a318pane;

    Flight flight;
    ArrayList<String> seatIds = new ArrayList<>();
    public static ArrayList<Button> reservedSeats = new ArrayList<>();

    @FXML
    public void exit() {
        new GeneralFunctions().close(exit);
    }


    public void userInfoForm(ActionEvent e) throws IOException {
        if (UserInfo_Controller.seatCount != Integer.parseInt(MainScreen_Controller.getNoOf_Tickets())) {
            new GeneralFunctions().switchSceneModality("UserInfo.fxml");
            Button tmp = (Button) e.getTarget();
            seatIds.add(((Button) e.getTarget()).getId());
            tmp.setText("X");
            tmp.setOpacity(0.1);
            Button seat = new Button();
            seat.setText(tmp.getText());
            seat.setId(tmp.getId());
            seat.setStyle(tmp.getStyle());
            seat.setOpacity(tmp.getOpacity());
            reservedSeats.add(seat);
        } else {
            new GeneralFunctions().switchSceneModality("Warning.fxml");
        }
    }

    public void done(ActionEvent e) throws IOException {
        if (UserInfo_Controller.seatCount == Integer.parseInt(MainScreen_Controller.getNoOf_Tickets())) {
            flight = new Flight(FlightInfo_Controller.departureFlight, UserInfo_Controller.person, FlightInfo_Controller.returnFlight, seatIds);
            new GeneralFunctions().reserveData(flight);
            new GeneralFunctions().switchScene(e, "Farewell.fxml");
        }
        else if (UserInfo_Controller.seatCount != Integer.parseInt(MainScreen_Controller.getNoOf_Tickets())) {
            new GeneralFunctions().switchSceneModality("Warning2.fxml");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ArrayList<Button> newButtons = new ArrayList<>();
            ArrayList<Flight> flight = new ArrayList<>(Objects.requireNonNull(GeneralFunctions.showReservedSeats()));
            for (Flight value : flight) {
                    for(String i : value.getSeatIds()){
                        Button button = new Button("X");
                        button.setId(i);
                        newButtons.add(button);
                    }
                }
                ObservableList<Node> children = a318pane.getChildren();
                for (int k = 0; k < children.size(); k++) {
                    Node child = children.get(k);

                    if (child instanceof Button oldButton) {

                        Optional<Button> newButtonOpt = newButtons.stream()
                                .filter(button -> button.getId().equals(oldButton.getId()))
                                .findFirst();

                        if (newButtonOpt.isPresent()) {
                            Button newButton = newButtonOpt.get();
                            newButton.setLayoutX(oldButton.getLayoutX());
                            newButton.setLayoutY(oldButton.getLayoutY());
                            newButton.setOpacity(0.1);
                            newButton.setStyle(oldButton.getStyle());
                            newButton.setPrefWidth(oldButton.getPrefWidth());
                            newButton.setPrefHeight(oldButton.getPrefHeight());
                            newButton.setOnAction(null);
                            a318pane.getChildren().set(k, newButton);
                            newButtons.remove(newButton);
                        }
                    }
                }

                a318pane.getChildren().addAll(newButtons);

            } catch(Exception e){
            System.out.println("No Previously Reserved Seats");
        }

        if(FlightInfo_Controller.disabled){
            try{
                ArrayList<Button> newButtons = new ArrayList<>();
                ArrayList<String> ids = new ArrayList<>();
                ids.add("A02");
                ids.add("B02");
                ids.add("C02");
                ids.add("D01");
                ids.add("E01");
                ids.add("F01");
                ids.add("A10");
                ids.add("B10");
                ids.add("C10");
                ids.add("D10");
                ids.add("E10");
                ids.add("F10");
                ids.add("A23");
                ids.add("B23");
                ids.add("C23");
                ids.add("D23");
                ids.add("E23");
                ids.add("F23");

                for(int i=0; i<18; i++){
                    Button button = new Button();
                    button.setId(ids.get(i));
                    newButtons.add(button);
                }
                ObservableList<Node> children = a318pane.getChildren();
                for (int k = 0; k < children.size(); k++) {
                    Node child = children.get(k);

                    if (child instanceof Button oldButton) {

                        Optional<Button> newButtonOpt = newButtons.stream()
                                .filter(button -> button.getId().equals(oldButton.getId()))
                                .findFirst();

                        if (newButtonOpt.isPresent()) {
                            Button newButton = newButtonOpt.get();
                            newButton.setText(oldButton.getText());
                            newButton.setLayoutX(oldButton.getLayoutX());
                            newButton.setLayoutY(oldButton.getLayoutY());
                            newButton.setStyle("-fx-background-color: #16ff00");
                            newButton.setPrefWidth(oldButton.getPrefWidth());
                            newButton.setPrefHeight(oldButton.getPrefHeight());
                            newButton.setOnAction(oldButton.getOnAction());
                            a318pane.getChildren().set(k, newButton);
                            newButtons.remove(newButton);
                        }
                    }
                }

                a318pane.getChildren().addAll(newButtons);

            }catch (Exception e){

            }
            try {
                new GeneralFunctions().switchSceneModality("DisabledMessage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
