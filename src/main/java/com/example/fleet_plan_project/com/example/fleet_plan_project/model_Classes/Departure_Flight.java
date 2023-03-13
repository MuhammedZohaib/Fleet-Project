package com.example.fleet_plan_project.model_Classes;

import java.io.Serializable;
import java.time.LocalDate;

public class Departure_Flight implements Serializable {
    private static LocalDate dateOfDeparture;

    public static LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public static void setDateOfDeparture(LocalDate dateOfDeparture) {
        Departure_Flight.dateOfDeparture = dateOfDeparture;
    }
    public String getDepartureOrigin() {
        return departureOrigin;
    }

    public void setDepartureOrigin(String departureOrigin) {
        this.departureOrigin = departureOrigin;
    }

    public String getDepartureDestination() {
        return departureDestination;
    }

    public void setDepartureDestination(String departureDestination) {
        this.departureDestination = departureDestination;
    }

    private String departureOrigin;

    public Departure_Flight(LocalDate dateOfDeparture, String departureOrigin, String departureDestination) {
        this.dateOfDeparture = dateOfDeparture;
        this.departureOrigin = departureOrigin;
        this.departureDestination = departureDestination;
    }

    @Override
    public String toString() {
        return "Departure_Flight{" +
                "dateOfDeparture=" + dateOfDeparture +
                ", departureOrigin='" + departureOrigin + '\'' +
                ", departureDestination='" + departureDestination + '\'' +
                '}';
    }

    private String departureDestination;


}
