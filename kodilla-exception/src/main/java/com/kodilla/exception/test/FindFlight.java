package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FindFlight{

    public void findFlight(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> flighMap = new HashMap<String,Boolean>();
        flighMap.put("POZ", true);
        flighMap.put("WAW", true);
        flighMap.put("WRO", true);
        try {
            for (Map.Entry<String, Boolean> airport : flighMap.entrySet()) {
                if (airport.getKey().equals(flight.getArrivalAirport())) {
                    System.out.println("Airport found: " + airport.getKey() + "; possible to use: " + airport.getValue());
                }
            }
        }catch (Exception e) {
            throw new RouteNotFoundException();
        }
    }
}
