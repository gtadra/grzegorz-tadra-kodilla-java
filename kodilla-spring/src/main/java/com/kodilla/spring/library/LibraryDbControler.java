package com.kodilla.spring.library;

import org.springframework.stereotype.Repository;


public class LibraryDbControler {

    public void saveData(){
        System.out.println("Saving data to the database");
    }

    public void loadData(){
        System.out.println("Loading data from the database");
    }
}
