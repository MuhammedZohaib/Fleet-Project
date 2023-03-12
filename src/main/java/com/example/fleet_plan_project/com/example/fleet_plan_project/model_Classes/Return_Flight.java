package com.example.fleet_plan_project.model_Classes;

import java.io.Serializable;
import java.time.LocalDate;

public class Return_Flight implements Serializable {
    private LocalDate returnDate;
    private String retOrigin;
    private String retDestination;
    private String noOfTickets;

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getRetOrigin() {
        return retOrigin;
    }

    public void setRetOrigin(String retOrigin) {
        this.retOrigin = retOrigin;
    }

    public String getRetDestination() {
        return retDestination;
    }

    public void setRetDestination(String retDestination) {
        this.retDestination = retDestination;
    }

    public String getNoOfTickets() {
        return noOfTickets;
    }

    @Override
    public String toString() {
        return "Return_Flight{" +
                "returnDate=" + returnDate +
                ", retOrigin='" + retOrigin + '\'' +
                ", retDestination='" + retDestination + '\'' +
                ", noOfTickets='" + noOfTickets + '\'' +
                '}';
    }

    public void setNoOfTickets(String noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public Return_Flight(LocalDate returnDate, String retOrigin, String retDestination, String noOfTickets) {
        this.returnDate = returnDate;
        this.retOrigin = retOrigin;
        this.retDestination = retDestination;
        this.noOfTickets = noOfTickets;
    }

}
