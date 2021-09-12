package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers){

        List<Integer> tempOddNumbers = new ArrayList<>();

        for(Integer number: numbers){
            if ((number % 2) == 0) tempOddNumbers.add(number);
        }
return tempOddNumbers;
    }
}
