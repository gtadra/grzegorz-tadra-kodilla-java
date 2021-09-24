package com.kodilla.testing.weather.stub;

import java.util.*;

public class WetherForecast {
    private Temperatures temperatures;

    public WetherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast(){
        Map<String,Double> resultMap = new HashMap<>();

        for (Map.Entry<String,Double> temperature: temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public Double temperaturesAvg(){

        Double result = 0.0;

        for (Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()){
            result+=temperature.getValue();
        }

        return result/temperatures.getTemperatures().size();
    }

    public Double tepmeratureMedian(){

        List<Double> tempArray = new ArrayList<>();

        for (Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()){
            tempArray.add(temperature.getValue());
        }

        Collections.sort(tempArray);
        if ((tempArray.size() % 2) != 0){
            return tempArray.get(tempArray.size()/2);
        } else {
            int indexArray = (int)tempArray.size()/2;
            return (tempArray.get(indexArray-1) + tempArray.get(indexArray))/2;
        }

    }
}
