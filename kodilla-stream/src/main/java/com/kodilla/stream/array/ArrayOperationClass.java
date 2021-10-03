package com.kodilla.stream.array;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class ArrayOperationClass implements ArrayOperations{

    @Override
    public double getAverageFn(int[] numbers) {
        Arrays.stream(numbers)
                .forEach(System.out::println);

        OptionalDouble result = IntStream.range(0, numbers.length)
                .mapToDouble(n -> numbers[n])
                .average();

        return result.getAsDouble();
    }
}
