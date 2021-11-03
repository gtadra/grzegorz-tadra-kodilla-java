package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private final List<String> books = new ArrayList<>();
    private LibraryDbControler libraryDbControler;


    public Library(LibraryDbControler libraryDbControler) {
        this.libraryDbControler = libraryDbControler;
    }

    public Library(){

    }

    public void saveToDb(){
        libraryDbControler.saveData();
    }

    public void loadFromDb(){
        libraryDbControler.loadData();
    }
}