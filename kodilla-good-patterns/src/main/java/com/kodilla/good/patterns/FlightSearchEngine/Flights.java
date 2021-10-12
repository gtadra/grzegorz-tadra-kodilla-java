package com.kodilla.good.patterns.FlightSearchEngine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Flights {
    private Set<SingleFlight> flights = new HashSet<>();

    public Flights(Set<SingleFlight> flights) {
        this.flights = flights;
    }

    public void addFlight(SingleFlight flight){
        flights.add(flight);
    }

    public boolean removeFlight(SingleFlight flight){
        return flights.remove(flight);
    }

    public void findFlight(String departureAirport, String arrivalAirport) {
        Set<SingleFlight> results =flights.stream()
                .filter(n -> (n.getDepartureAirport() == departureAirport || n.getArrivalAirport() == arrivalAirport))
                .collect(Collectors.toSet());

        for (SingleFlight flight1 : results) {

            if (flight1.getArrivalAirport() == arrivalAirport && flight1.getDepartureAirport()==departureAirport) {
                System.out.println("Direct: " + flight1 + "\n");
            }

            for (SingleFlight flight2 : results) {
                if ((flight1.getDepartureAirport() == flight2.getArrivalAirport())
                        && (flight1.getArrivalAirport() == arrivalAirport)
                        && (flight2.getDepartureAirport() == departureAirport)) {

                    System.out.println("Undirect: " + flight2);
                    System.out.println("Undirect: " + flight1 + "\n");

                }
            }
        }
    }
}
