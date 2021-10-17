package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Library {

    private final List<String> books = new ArrayList<>();

    @Autowired
    private LibraryDbControler libraryDbControler;

    public void saveToDb(){
        libraryDbControler.saveData();
    }

    public void loadFromDb(){
        libraryDbControler.loadData();
    }
}