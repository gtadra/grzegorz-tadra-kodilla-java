package com.kodilla.stream;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.Locale;

public class StreamMain {

    public static void main(String[] args) {

        Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("Execute code from variable codeToExecute");
        processor.execute(codeToExecute);
        // wywolanie bez zmniennej codeToExecute
        processor.execute(() -> System.out.println("Execute without variable codeToExecute"));

        // lambda with two arguments
        ExpessionExecutor expessionExecutor = new ExpessionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expessionExecutor.executeExpression(10,5,(a,b) -> a+b);
        expessionExecutor.executeExpression(10,5,(a,b) -> a-b);
        expessionExecutor.executeExpression(10,5,(a,b) -> a*b);
        expessionExecutor.executeExpression(10,5,(a,b) -> a/b);

        System.out.println("Calculating expressions with method references");
        expessionExecutor.executeExpression(10,5, FunctionalCalculator::multiplayAByB);
        expessionExecutor.executeExpression(10,5, FunctionalCalculator::addAToB);
        expessionExecutor.executeExpression(10,5, FunctionalCalculator::subBFromA);
        expessionExecutor.executeExpression(10,5, FunctionalCalculator::divideAByB);

        System.out.println("Task 7.1 - Text beautifier");
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("text to be decorate", textToBeDecorate -> "ABC " + textToBeDecorate);
        poemBeautifier.beautify("text to be decorate", textToBeDecorate -> textToBeDecorate.toUpperCase(Locale.ROOT));
        poemBeautifier.beautify("text to be decorate", textToBeDecorate -> "*** " + textToBeDecorate + " ***");
        poemBeautifier.beautify("text to be decorate", textToBeDecorate -> "Super text -->" + textToBeDecorate);



    }
}
