package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WetherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    //private static HashMap<Object, Object> temperaturesMap1;
    @Mock
    private Temperatures temperaturesMock;
    private static Map<String,Double> temperaturesMap;

    @BeforeAll
     public static void prepareTestData() {
        temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.0);
        temperaturesMap.put("Krakow", 26.0);
        temperaturesMap.put("Wroclaw", 24.0);
        temperaturesMap.put("Warszawa", 25.0);
        temperaturesMap.put("Gdansk", 25.0);
    }

    @Test
    void testCalculateForecastWithMock(){
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WetherForecast weatherForecast = new WetherForecast(temperaturesMock);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        Assertions.assertEquals(5,quantityOfSensors);
    }

    @Test
    void testTemperaturesAvgWithMock(){
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WetherForecast weatherForecast = new WetherForecast(temperaturesMock);
        //When
        double TemperatureAvg = weatherForecast.temperaturesAvg();
        //Then
        Assertions.assertEquals(25.0,TemperatureAvg);
    }

    @Test
    void testTempMediane(){
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WetherForecast weatherForecast = new WetherForecast(temperaturesMock);
        //When
        double TemperatureMed = weatherForecast.tepmeratureMedian();
        //Then
        Assertions.assertEquals(25.0,TemperatureMed);
    }

}
