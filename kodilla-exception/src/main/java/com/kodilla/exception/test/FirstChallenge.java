package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {

        double result = 0;

        try {
            return a/b;
        } catch (ArithmeticException e){
            System.out.println("Error: " + e);
            return 0;
        } finally {
            System.out.println("END");
        }

    }

    public static void main(String[] args){
        FirstChallenge firstChallenge = new FirstChallenge();
        double result = firstChallenge.divide(3,0);

        System.out.println(result);
    }
}
