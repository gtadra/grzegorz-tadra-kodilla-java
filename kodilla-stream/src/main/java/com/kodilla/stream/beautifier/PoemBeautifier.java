package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String textToBeDecorate, PoemDecorator decorExpression){

        String result = decorExpression.decorate(textToBeDecorate);
        System.out.println(result);
    }
}
