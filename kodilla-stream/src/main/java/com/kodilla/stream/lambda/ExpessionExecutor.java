package com.kodilla.stream.lambda;

public class ExpessionExecutor {

    public void executeExpression(double a, double b, MathExpression mathExpression){
        double result = mathExpression.calcutaleExpression(a,b);
        System.out.println("Result equels: " + result);
    }
}
