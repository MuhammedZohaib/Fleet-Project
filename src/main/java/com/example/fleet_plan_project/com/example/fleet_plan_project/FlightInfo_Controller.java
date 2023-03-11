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
    private Text retDateValidation;
    @FXML
    private Text retDestinationValidation;
    @FXML
    private Text retOriginValidation;
    @FXML
    private Text returnTicketsValidation;

    String alphabetRegex = "^[a-zA-Z ]*$";

    public static String depOriginAirport;
    public static String depDestinationAirport;
    public static LocalDate depDate;
    public static Boolean randomSeats;
    public static Boolean disabled;
    public static Boolean returnReservation;
    public static String retOriginAirport;
    public static String retDestinationAirport;
    public static LocalDate retDate;
    public static String noOfRetTickets;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            if(Integer.parseInt(MainScreen_Controller.getHours()) <= 2){
                welcomeText.setText("Welcome to Airbus A318");
            }
            else
                welcomeText.setText("Welcome to Boeing B737");
        }
        catch (NullPointerException e){
            System.out.println(e);
        }
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
        if(returnYes.isSelected() && returnReservation && originValidation.getText().equals("") && destinationValidation.getText().equals("") && departureDateValidation.getText().equals("")){
            new GeneralFunctions().switchScene(e,"ReturnReservationForm.fxml");
        }
        else if(returnNo.isSelected() && Integer.parseInt(MainScreen_Controller.getHours()) <= 2 && !returnReservation && originValidation.getText().equals("") && destinationValidation.getText().equals("") && departureDateValidation.getText().equals("")){
            new GeneralFunctions().switchScene(e, "A318.fxml");
        }
        else if(returnNo.isSelected() && Integer.parseInt(MainScreen_Controller.getHours()) >2 && !returnReservation && originValidation.getText().equals("") && destinationValidation.getText().equals("") && departureDateValidation.getText().equals("")){
            new GeneralFunctions().switchScene(e,"B737.fxml");
        }
    }
    public void saveReturnReservation(ActionEvent e) throws IOException {
        retOriginAirport = returnOriginField.getText();
        retDestinationAirport = returnDestinationField.getText();
        noOfRetTickets = returnNoOfTickets.getText();
        try {
            retDate = returnDateField.getValue();
        }
        catch (NullPointerException exception){
            retDateValidation.setText("! Date cannot Be empty");
        }

        if(!retOriginAirport.matches(alphabetRegex)){
            returnOriginField.setText("");
            retOriginValidation.setText("! Origin Airport field cannot contain Numbers");
        }
        else if(retOriginAirport.isBlank() || retOriginAirport.isEmpty()){
            returnOriginField.setText("");
            retOriginValidation.setText("! Origin Airport cannot be empty");
        }
        if(!retDestinationAirport.matches(alphabetRegex)){
            returnDestinationField.setText("");
            retDestinationValidation.setText("! Destination Airport Field cannot contain Numbers");
        }
        else if(retDestinationAirport.isEmpty() || retDestinationAirport.isBlank())
        {
            returnDestinationField.setText("");
            retDestinationValidation.setText("! Destination Airport cannot be empty");
        }
        try {
            if(retDate.getYear() > 2023){
                returnDateField.setValue(null);
                retDateValidation.setText("! Invalid Date");
            }
        }
        catch (NullPointerException exception){
            returnDateField.setValue(null);
            retDateValidation.setText("! Invalid Date");
        }
        if(!noOfRetTickets.matches(new MainScreen_Controller().numericRegex)){
            returnTicketsValidation.setText("! No. of Tickets field cannot contain Alphabets");
        }
        else if(noOfRetTickets.isBlank() || noOfRetTickets.isEmpty()){
            returnNoOfTickets.setText("");
            returnTicketsValidation.setText("! No. of Tickets Field cannot be empty");
        }
        else if(Integer.parseInt(noOfRetTickets) == 0){
            returnNoOfTickets.setText("");
            returnTicketsValidation.setText("! No. of Return Tickets cannot be zero");
        }

        else if( retOriginValidation.getText().equals("") &&  retDestinationValidation.getText().equals("") && retDateValidation.getText().equals("") && returnTicketsValidation.getText().equals("") && Integer.parseInt(MainScreen_Controller.getHours()) <=2 ){
            //TODO File Handling Here
            new GeneralFunctions().switchScene(e,"A318.fxml");
        }
        else if( retOriginValidation.getText().equals("") &&  retDestinationValidation.getText().equals("") && retDateValidation.getText().equals("") && returnTicketsValidation.getText().equals("") && Integer.parseInt(MainScreen_Controller.getHours()) >2 ){
            //TODO File Handling Here
            new GeneralFunctions().switchScene(e,"B737.fxml");
        }
    }
    public void resetValidations(){
        originValidation.setText("");
        destinationValidation.setText("");
        departureDateValidation.setText("");
    }
    public void resetReturnValidations(){
        retOriginValidation.setText("");
        retDestinationValidation.setText("");
        retDateValidation.setText("");
        returnTicketsValidation.setText("");
    }
    public void exit(){
        new GeneralFunctions().close(exit);
    }
    public void reservationExit(){
        new GeneralFunctions().close(reservationCloseButton);
    }


}
