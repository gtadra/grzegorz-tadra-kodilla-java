package com.kodilla.hibernate.manytomany.facade;

public class SearchExceptation extends Exception {
    public static String INFO_NO_EMPLOYEE = "No employee found";
    public static String INFO_NO_COMPANY = "No company found";

    public SearchExceptation(String message) {
        super(message);
    }
}
