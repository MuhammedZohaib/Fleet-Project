package com.example.fleet_plan_project.model_Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Flight extends ArrayList<Flight> implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Departure_Flight departureFlights;
    private ArrayList<Person> clients;

    public ArrayList<String> getSeatIds() {
        return seatIds;
    }

    public Flight(Departure_Flight departureFlights, ArrayList<Person> clients, Return_Flight returnFlight, ArrayList<String> seatIds) {
        this.departureFlights = departureFlights;
        this.clients = clients;
        this.returnFlight = returnFlight;
        this.seatIds = seatIds;
    }

    private Return_Flight returnFlight;
    ArrayList<String> seatIds;





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
