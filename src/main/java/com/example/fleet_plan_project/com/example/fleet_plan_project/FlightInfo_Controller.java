package com.example.fleet_plan_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;



public class FlightInfo_Controller implements Initializable {
    @FXML
    private DatePicker dateField;
    @FXML
    private Text departureDateValidation;
    @FXML
    private TextField destinationField;
    @FXML
    private Text destinationValidation;
    @FXML
    private RadioButton disabledNo;
    @FXML
    private RadioButton disabledYes;
    @FXML
    private Button exit;
    @FXML
    private RadioButton manualRButton;
    @FXML
    private Button nextButton;
    @FXML
    private TextField originField;
    @FXML
    private Text originValidation;
    @FXML
    private RadioButton randomRButton;
    @FXML
    private RadioButton returnNo;
    @FXML
    private RadioButton returnYes;
    @FXML
    private Text welcomeText;
    @FXML
    private Button reservationCloseButton;
    @FXML
    private DatePicker returnDateField;
    @FXML
    private TextField returnDestinationField;
    @FXML
    private TextField returnNoOfTickets;
    @FXML
    private TextField returnOriginField;
    @FXML
    private Button returnSaveButton;

    String alphabetRegex = "^[a-zA-Z ]*$";

    public static String depOriginAirport;
    public static String depDestinationAirport;
    public static LocalDate depDate;
    public static Boolean randomSeats;
    public static Boolean disabled;
    public static Boolean returnReservation;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Integer.parseInt(MainScreen_Controller.getHours()) <= 2){
            welcomeText.setText("Welcome to Airbus A318");
        }
        else
            welcomeText.setText("Welcome to Boeing B737");
    }
    public void exit(){
        new GeneralFunctions().close(exit);
    }
    public void next(ActionEvent e) throws IOException {
        depOriginAirport = originField.getText();
        depDestinationAirport = destinationField.getText();
        try{
            depDate = dateField.getValue();
        }
        catch (NullPointerException error){
            departureDateValidation.setText("! Departure Date Cannot be empty");
        }

        if(randomRButton.isSelected()){
            randomSeats = true;
        }
        else if(manualRButton.isSelected()){
            randomSeats = false;
        }
        if(disabledYes.isSelected()){
            disabled = true;
        }
        else if (disabledNo.isSelected()){
            disabled = false;
        }
        if(returnYes.isSelected()){
            returnReservation = true;
        }
        else if(returnNo.isSelected()){
            returnReservation = false;
        }

        if(!depOriginAirport.matches(alphabetRegex)){
            originValidation.setText("! Origin Airport field cannot contain Numbers");
        }
        else if(depOriginAirport.isBlank() || depOriginAirport.isEmpty()){
            originValidation.setText("! Origin Airport cannot be empty");
        }
        if(!depDestinationAirport.matches(alphabetRegex)){
            destinationValidation.setText("! Destination Airport Field cannot contain Numbers");
        }
        else if(depDestinationAirport.isEmpty() || depDestinationAirport.isBlank())
        {
            destinationValidation.setText("! Destination Airport cannot be empty");
        }
        try {
            if(depDate.getYear() > 2023){
                departureDateValidation.setText("! Invalid Date");
        }
        }
        catch (NullPointerException exception){
            departureDateValidation.setText("! Invalid Date");
        }
        if(returnYes.isSelected() && returnReservation == true && originValidation.getText().equals("") && destinationValidation.getText().equals("") && departureDateValidation.getText().equals("")){
            new GeneralFunctions().switchSceneModality("ReturnReservationForm.fxml");
        }
        else if(returnNo.isSelected() && Integer.parseInt(MainScreen_Controller.getHours()) <= 2 && returnReservation == false && originValidation.getText().equals("") && destinationValidation.getText().equals("") && departureDateValidation.getText().equals("")){
            new GeneralFunctions().switchScene(e, "A318.fxml");
        }
        else if(returnNo.isSelected() && Integer.parseInt(MainScreen_Controller.getHours()) >2 && returnReservation == false && originValidation.getText().equals("") && destinationValidation.getText().equals("") && departureDateValidation.getText().equals("")){
            new GeneralFunctions().switchScene(e,"B737.fxml");
        }
    }
    public void resetValidations(){
        originValidation.setText("");
        destinationValidation.setText("");
        departureDateValidation.setText("");
    }


}
