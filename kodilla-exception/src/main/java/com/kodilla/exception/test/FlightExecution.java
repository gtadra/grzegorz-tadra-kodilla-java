package com.kodilla.exception.test;

public class FlightExecution {

    public static void main(String[] args) {
        Flight flight1 = new Flight("POZ", "WRO");
        FindFlight findFlight = new FindFlight();

        try {
            findFlight.findFlight(flight1);
        }catch (RouteNotFoundException e){
            System.out.println("Flight not found");
        }
    }

}
