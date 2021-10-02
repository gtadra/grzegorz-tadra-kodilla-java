package com.kodilla.stream;


import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.person.People;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        // Task from section 7.3
        Forum forumUsers = new Forum();


        Map<Integer, ForumUser> theResultMapForumUser = forumUsers.getList().stream()
                .filter(s -> s.getSex().equals('M'))
                .filter(s -> s.getUserBirthDate().isBefore(LocalDate.now().minusYears(20)))
                .filter(s -> s.getUserPublishedPostsCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserId, ForumUser -> ForumUser));

        System.out.println("# Elements: " + theResultMapForumUser.size());
        theResultMapForumUser.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);




    }
}
