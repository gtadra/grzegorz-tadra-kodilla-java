package com.kodilla.spring.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig {

    @Bean
    public Library library(){
        return new Library(libraryDbControler());
    }

    @Bean
    public LibraryDbControler libraryDbControler(){
        return new LibraryDbControler();
    }
}
