package com.example.fleet_plan_project;

//Import Statements
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class MainScreen_Controller  {
    @FXML
    private TextField durationOfFlight; //JavaFx Component from Fxml file
    @FXML
    private Text durationOfFlight_Validation; //JavaFx Component from Fxml file

    @FXML
    private TextField noOfTickets; //JavaFx Component from Fxml file
    @FXML
    private Text noOfTickets_Validation; //JavaFx Component from Fxml file
    @FXML
    private Button exit; //JavaFx Component from Fxml file
    String numericRegex = "^[0-9]*$"; //Regular Expression to ensure input is only Numeric

    private static String hours; //Access Modifier to Private -> Encapsulation
    private static String noOf_Tickets; //Access Modifier to Private -> Encapsulation
    public void exit(){ // A function to exit
        new GeneralFunctions().close(exit); //Anonymous object of General Function class
    }

    static String getHours() { //Getter Method
        return hours;
    }
    static String getNoOf_Tickets() { //Getter Method
        return noOf_Tickets;
    }


    @FXML
    public void next(ActionEvent e) throws IOException { //A validator and Scene Switch Method
        hours = durationOfFlight.getText(); //Variable for Flight duration
        noOf_Tickets = noOfTickets.getText(); //Variable fot No. of Tickets

        if(!hours.matches(numericRegex)){ //Validation
            durationOfFlight_Validation.setText("! Flight Duration Should be a Number");
        }
        else if(hours.equals("0")){ //Validation
            durationOfFlight_Validation.setText("! Flight Duration Should be greater than zero");
        }
        else if(hours.isBlank() || hours.isEmpty()){ //Validation
            durationOfFlight_Validation.setText("! Flight Duration Cannot be Empty");
        }
        if(!noOf_Tickets.matches(numericRegex)){ //Validation
            noOfTickets_Validation.setText("! Number of Tickets Should be a Number");
        }
        else if(noOf_Tickets.equals("0")){ //Validation
            noOfTickets_Validation.setText("! Tickets Should be Greater than zero");
        }
        else if(noOf_Tickets.isEmpty() || noOf_Tickets.isBlank()){ //Validation
            noOfTickets_Validation.setText("! Number of Tickets Cannot be Empty");
        }
        //Validation and Scene Switch to Flight A318
        else if(Integer.parseInt(hours) <= 2 && noOfTickets_Validation.getText().equals("") && durationOfFlight_Validation.getText().equals("")){
            new GeneralFunctions().switchScene(e,"Flight_Info.fxml"); //Anonymous Object
        }
        //Validation and Scene Switch to Flight Boeing 737
        else if(Integer.parseInt(hours) > 2 && noOfTickets_Validation.getText().equals("") && durationOfFlight_Validation.getText().equals("")){
            new GeneralFunctions().switchScene(e,"Flight_Info.fxml"); //Anonymous Object
        }
    }
    public void resetValidation(){ //A method to reset the text in Validation Upon mouse click
        durationOfFlight_Validation.setText("");
        noOfTickets_Validation.setText("");
    }

}
