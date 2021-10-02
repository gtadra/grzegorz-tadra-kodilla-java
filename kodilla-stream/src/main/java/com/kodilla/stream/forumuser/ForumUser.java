package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    final Integer userId;
    final String username;
    final Character sex;
    final LocalDate userBirthDate;
    final Integer userPublishedPostsCount;

    public ForumUser(Integer userId, String username, Character sex, LocalDate userBirthDate, Integer userPublishedPostsCount) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.userBirthDate = userBirthDate;
        this.userPublishedPostsCount = userPublishedPostsCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Character getSex() {
        return sex;
    }

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public Integer getUserPublishedPostsCount() {
        return userPublishedPostsCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", userBirthDate=" + userBirthDate +
                ", userPublishedPostsCount=" + userPublishedPostsCount +
                '}';
    }
}
