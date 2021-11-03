package com.kodilla.spring.portofolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

   @Autowired
    TaskList toDo;
    @Autowired
   TaskList inProgress;
    @Autowired
   TaskList done;


   @Bean
    public Board getBoard(){
       return new Board(toDo,inProgress,done);
   }

   @Bean(name = "toDo")
  //  @Scope("prototype")
    public TaskList getToDo(){
       TaskList toDoList = new TaskList();
       return toDoList;
   }

    @Bean(name = "inProgress")
    //  @Scope("prototype")
    public TaskList getInProgress(){
        TaskList inProgressList = new TaskList();
        return inProgressList;
    }

    @Bean(name = "done")
    //  @Scope("prototype")
    public TaskList done(){
        TaskList doneList = new TaskList();
        return doneList;
    }

}
