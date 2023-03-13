package com.example.fleet_plan_project;

//Import Statements
import com.example.fleet_plan_project.model_Classes.Departure_Flight;
import com.example.fleet_plan_project.model_Classes.Flight;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.ArrayList;

public class GeneralFunctions {
    LoadingScreen_Controller obj = new LoadingScreen_Controller(); //Initialized an Object to reuse previously declared Stages and Scenes

    //A General Method with Implements the functionality of Scene Switching
    public  void switchScene(Event e, String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        obj.stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        obj.scene = new Scene(fxmlLoader.load());
        obj.stage.setScene(obj.scene);
        obj.stage.centerOnScreen();
        obj.stage.show();
    }
    //An overloaded method to open two stages while only one is active
    public void switchSceneModality(String fxml) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load());
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();
    }
    //A Function to Close the Application
    public void close(Button b){
        obj.stage = (Stage) b.getScene().getWindow();
        obj.stage.close();
    }

    public void reserveData(Flight clientInfo) throws IOException {
        String reservationDate;
        if(Integer.parseInt(MainScreen_Controller.getHours()) <= 2){
            reservationDate = "A318_"+clientInfo.getDepartureFlights().getDateOfDeparture().toString() + ".txt";
        }
        else {
            reservationDate = "B737_"+clientInfo.getDepartureFlights().getDateOfDeparture().toString() + ".txt";
        }
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(reservationDate, true); // true to append, false to overwrite
            oos = new MyObjectOutputStream(fos);
            oos.writeObject(clientInfo);
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
    public static ArrayList<Flight> showReservedSeats(){
        String fileName;
        ArrayList <Flight> tmp = new ArrayList<>();
        if(Integer.parseInt(MainScreen_Controller.getHours()) <= 2){
            fileName = "A318_"+Departure_Flight.getDateOfDeparture()+".txt";
        }
        else {
            fileName = "B737_"+Departure_Flight.getDateOfDeparture()+".txt";
        }
        File file = new File(fileName);
        if (file.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream(file);
                MyObjectInputStream objIn = new MyObjectInputStream(fileIn);
                while (true){
                    Flight flight = (Flight) objIn.readObject();
                    tmp.add(flight);
                }
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
            finally {
                return tmp;

            }

        } else {
            System.out.println("File does not exist.");
            return null;
        }

    }
    }




