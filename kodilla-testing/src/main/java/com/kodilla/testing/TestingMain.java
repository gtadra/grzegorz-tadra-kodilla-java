package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {

    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();

        if(result.equals("theForumUser")){
            System.out.println("OK  - Test username");
        } else {
            System.out.println("ERROR!  - Test username");
        }

// Calculator test
        Calculator matematicalOperation = new Calculator();
        int resultMatOp = matematicalOperation.add(3,4);

        if(resultMatOp == 7){
            System.out.println("OK  - Test Calculator.add()");
        } else {
            System.out.println("ERROR! - Test Calculator.add()");
        }

        resultMatOp = matematicalOperation.substract(5,4);

        if(resultMatOp == 1){
            System.out.println("OK  - Test Calculator.substract()");
        } else {
            System.out.println("ERROR! - Test Calculator.substract()");
        }

    }
}
