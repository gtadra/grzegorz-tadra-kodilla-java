package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum(){
        forumUserList.add(new ForumUser(1,"User1",'M', LocalDate.parse("1985-04-05"),16));
        forumUserList.add(new ForumUser(2,"User2",'M', LocalDate.parse("1986-04-05"),26));
        forumUserList.add(new ForumUser(3,"User3",'F', LocalDate.parse("1987-04-05"),63));
        forumUserList.add(new ForumUser(4,"User4",'F', LocalDate.parse("1988-04-05"),44));
        forumUserList.add(new ForumUser(5,"User5",'M', LocalDate.parse("2001-04-05"),1));
        forumUserList.add(new ForumUser(6,"User6",'M', LocalDate.parse("2005-04-05"),10));
        forumUserList.add(new ForumUser(7,"User7",'M', LocalDate.parse("1981-04-05"),6));
        forumUserList.add(new ForumUser(8,"User8",'F', LocalDate.parse("1982-04-05"),5));
        forumUserList.add(new ForumUser(9,"User9",'M', LocalDate.parse("1983-04-05"),88));
        forumUserList.add(new ForumUser(10,"User10",'M', LocalDate.parse("1984-04-05"),0));
    }

    public List<ForumUser> getList(){
        return new ArrayList<>(forumUserList);
    }

}
