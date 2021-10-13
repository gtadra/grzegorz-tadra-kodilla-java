package com.kodilla.good.patterns.FlightSearchEngine;

import java.util.HashSet;

public class Application {

    public static void main(String args[]){
        Flights flights = new Flights(new HashSet<>());
        flights.addFlight( new SingleFlight("WAR", "WRO"));
        flights.addFlight( new SingleFlight("WAR", "ZGA"));
        flights.addFlight( new SingleFlight("WAR", "POZ"));
        flights.addFlight( new SingleFlight("WRO", "POZ"));
        flights.addFlight( new SingleFlight("WRO", "WAR"));
        flights.addFlight( new SingleFlight("WRO", "ZGA"));
        flights.addFlight( new SingleFlight("ZGA", "WRO"));


        System.out.println("\n ---=== All flights fom selected destination ===---");
        flights.findAllFlightsFrom("WRO");

        System.out.println("\n ---=== All flights to selected destination ===---");
        flights.findAllFlightsTo("WRO");

        System.out.println("\n ---=== All possible flights from one destination to another ===---");
        flights.findAllPossibleFlights("WAR", "WRO");

        System.out.println("\n ---=== Flight via connecting Airport ===---");
        flights.findConnectedFlight("WAR","ZGA", "WRO");
    }
}
