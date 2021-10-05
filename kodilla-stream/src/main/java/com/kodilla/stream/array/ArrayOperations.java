package com.kodilla.stream.array;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    public static double getAverageFn(int[] numbers) {
        Arrays.stream(numbers)
                .forEach(System.out::println);

        Double result = IntStream.range(0, numbers.length)
                .mapToDouble(n -> numbers[n])
                .average().getAsDouble();

        return result;
    }
}
