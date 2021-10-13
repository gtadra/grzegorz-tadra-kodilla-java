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

    public void findAllFlightsFrom(String departureAirport){
        flights.stream()
                .filter(n -> n.getDepartureAirport().equals(departureAirport))
                .forEach(System.out::println);
    }

    public void findAllFlightsTo(String arrivalAirport){
        flights.stream()
                .filter(n -> n.getArrivalAirport().equals(arrivalAirport))
                .forEach(System.out::println);
    }

    public void findAllPossibleFlights(String departureAirport, String arrivalAirport) {
        Set<SingleFlight> results =flights.stream()
                .filter(n -> (n.getDepartureAirport().equals(departureAirport) || n.getArrivalAirport().equals(arrivalAirport)))
                .collect(Collectors.toSet());

        for (SingleFlight flight1 : results) {

            if (flight1.getArrivalAirport().equals(arrivalAirport) && flight1.getDepartureAirport().equals(departureAirport)) {
                System.out.println("Direct: " + flight1 + "\n");
            }

            for (SingleFlight flight2 : results) {
                if ((flight1.getDepartureAirport().equals(flight2.getArrivalAirport()))
                        && (flight1.getArrivalAirport().equals(arrivalAirport))
                        && (flight2.getDepartureAirport().equals(departureAirport))) {

                    System.out.println("Undirect: " + flight2);
                    System.out.println("Undirect: " + flight1 + "\n");

                }
            }
        }

    }

    public void findConnectedFlight(String departureAirport, String connectingAirport, String arrivalAirport){
        Set<SingleFlight> results = flights.stream()
                .filter(n -> (n.getDepartureAirport().equals(departureAirport) && n.getArrivalAirport().equals(connectingAirport))
                        || (n.getDepartureAirport().equals(connectingAirport) && n.getArrivalAirport().equals(arrivalAirport)))
                .collect(Collectors.toSet());

        for (SingleFlight flight1 : results) {
            for (SingleFlight flight2 : results) {
                if (flight1.getArrivalAirport().equals(flight2.getDepartureAirport())) {
                    System.out.println(flight1 + "\n" + flight2);
                }
            }
        }
    }
}
