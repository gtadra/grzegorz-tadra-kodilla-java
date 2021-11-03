package com.kodilla.spring.library;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class Library {
    private final List<String> books = new ArrayList<>();
    private LibraryDbControler libraryDbControler;


    public Library(final LibraryDbControler libraryDbControler) {
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