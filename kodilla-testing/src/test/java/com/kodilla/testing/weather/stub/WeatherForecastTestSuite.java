package com.kodilla.testing.weather.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeatherForecastTestSuite {

    @Test
    void testCalculateForecastWithStub(){
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WetherForecast wetherForecast = new WetherForecast(temperatures);

        //When
        int quantityOfSensors = wetherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5,quantityOfSensors);

    }
}
