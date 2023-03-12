package com.example.fleet_plan_project.model_Classes;

import javafx.scene.control.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class Flight implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Departure_Flight departureFlights;
    private ArrayList<Person> clients;
    private Return_Flight returnFlight;
    private static  ArrayList<Button> reservedSeats;


    @Override
    public String toString() {
        return "Flight{" +
                "departureFlights=" + departureFlights.toString() +
                ", clients=" + clients.toString() +
                ", returnFlight=" + returnFlight +
                ", reservedSeats=" + reservedSeats +
                '}';
    }

    public Flight(Departure_Flight departureFlights, ArrayList<Person> clients, Return_Flight returnFlight, ArrayList<Button> reservedSeats) {
        this.departureFlights = departureFlights;
        this.clients = clients;
        this.returnFlight = returnFlight;
        this.reservedSeats = reservedSeats;
    }

    public ArrayList<Button> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(ArrayList<Button> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public Departure_Flight getDepartureFlights() {
        return departureFlights;
    }

    public void setDepartureFlights(Departure_Flight departureFlights) {
        this.departureFlights = departureFlights;
    }

    public ArrayList<Person> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Person> clients) {
        this.clients = clients;
    }

    public Return_Flight getReturnFlight() {
        return returnFlight;
    }

    public void setReturnFlight(Return_Flight returnFlight) {
        this.returnFlight = returnFlight;
    }
}
