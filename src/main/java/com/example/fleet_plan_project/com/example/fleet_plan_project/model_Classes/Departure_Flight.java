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

    public static String getDepartureOrigin() {
        return departureOrigin;
    }

    public static void setDepartureOrigin(String departureOrigin) {
        Departure_Flight.departureOrigin = departureOrigin;
    }

    public static String getDepartureDestination() {
        return departureDestination;
    }

    public static void setDepartureDestination(String departureDestination) {
        Departure_Flight.departureDestination = departureDestination;
    }

    private static String departureOrigin;

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

    private static String departureDestination;


}
