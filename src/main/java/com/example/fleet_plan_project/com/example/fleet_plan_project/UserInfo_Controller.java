package com.example.fleet_plan_project;

import com.example.fleet_plan_project.model_Classes.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class UserInfo_Controller {
    @FXML
    private TextField age;

    @FXML
    private Text ageValidation;

    @FXML
    private Text nameValidation;

    @FXML
    private Text phoneNumberValidation;

    @FXML
    private TextField name;
    @FXML
    private TextField phoneNumber;
    @FXML
    private Button reserveSeat;
    @FXML
    private Button userInfoClose;
    String alphabetRegex = "^[a-zA-Z ]*$";
    public static String clientName;
    public static String clientAge;
    public static String clientPhoneNumber = null;

    public static ArrayList<Person> person = new ArrayList<>();

    public int noOfSeats = Integer.parseInt(MainScreen_Controller.getNoOf_Tickets());
    public static int seatCount = 0;

    public void close(){
        new GeneralFunctions().close(userInfoClose);
    }
    public void exit(){
        new GeneralFunctions().close(reserveSeat);
    }
    public void reserve(ActionEvent e){
        clientName = name.getText();
        clientAge = age.getText();
        clientPhoneNumber = phoneNumber.getText();

        if(!clientName.matches(alphabetRegex)){
            name.setText("");
            nameValidation.setText("! Name field cannot contain Numbers");
        }
        else if(clientName.isBlank() || clientName.isEmpty()){
            name.setText("");
            nameValidation.setText("! Name field cannot be empty");
        }
        if(!clientPhoneNumber.matches(new MainScreen_Controller().numericRegex)){
            phoneNumber.setText("");
            phoneNumberValidation.setText("! Phone Number Field cannot contain Alphabets");
        }
        if(clientAge.isEmpty() || clientAge.isBlank())
        {   age.setText("");
            ageValidation.setText("! Age Field cannot be empty");
        }
        else if(!clientAge.matches(new MainScreen_Controller().numericRegex)){
            age.setText("");
            ageValidation.setText("! Age cannot be contain Numbers");
        }
        else if(nameValidation.getText().equals("") && phoneNumberValidation.getText().equals("") && ageValidation.getText().equals("")){
            Person client = new Person(clientName,clientAge,clientPhoneNumber);
            person.add(client);
            exit();
            seatCount++;
        }

    }
        public void resetValidations(){
            nameValidation.setText("");
            ageValidation.setText("");
            phoneNumberValidation.setText("");
        }
}
