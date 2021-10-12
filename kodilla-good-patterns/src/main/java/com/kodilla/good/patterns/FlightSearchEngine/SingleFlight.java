package com.kodilla.good.patterns.FlightSearchEngine;

public class SingleFlight {
    private String departureAirport;
    private String arrivalAirport;

    public SingleFlight(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }


    @Override
    public String toString() {
        return "Flight -->" +
                "departure: '" + departureAirport + '\'' +
                ", arrival: '" + arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleFlight that = (SingleFlight) o;

        if (!departureAirport.equals(that.departureAirport)) return false;
        return arrivalAirport.equals(that.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return departureAirport.hashCode();
    }
}
