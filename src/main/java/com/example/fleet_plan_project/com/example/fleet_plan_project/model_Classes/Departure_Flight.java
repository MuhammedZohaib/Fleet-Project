package com.example.fleet_plan_project.model_Classes;

import java.time.LocalDate;

public class Departure_Flight {
    private LocalDate dateOfDeparture;
    private String departureOrigin;

    public Departure_Flight(LocalDate dateOfDeparture, String departureOrigin, String departureDestination) {
        this.dateOfDeparture = dateOfDeparture;
        this.departureOrigin = departureOrigin;
        this.departureDestination = departureDestination;
    }

    private String departureDestination;


}
