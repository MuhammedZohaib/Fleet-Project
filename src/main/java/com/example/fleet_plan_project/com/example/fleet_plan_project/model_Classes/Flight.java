package com.example.fleet_plan_project.model_Classes;

import java.util.ArrayList;

public class Flight {
    private Departure_Flight departureFlights;
    private ArrayList<Person> clients;
    private Return_Flight returnFlight;

    public Flight(Departure_Flight departureFlights, ArrayList<Person> clients, Return_Flight returnFlight) {
        this.departureFlights = departureFlights;
        this.clients = clients;
        this.returnFlight = returnFlight;
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
