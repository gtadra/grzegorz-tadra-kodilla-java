package com.kodilla.testing.statistics;

public class CalculateStatistics{

    private Statistics statistics;
    private int userQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;


    public CalculateStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics) {

        this.userQuantity = statistics.usersNames().size();
        this.postsQuantity = statistics.postsCount();
        this.commentsQuantity = statistics.commentsCount();

        double tempAvgPostsPerUser = (double) postsQuantity/userQuantity;
        if (Double.isNaN(tempAvgPostsPerUser)){ tempAvgPostsPerUser = 0.0;}
        this.avgPostsPerUser = tempAvgPostsPerUser;

        double tempAvgCommentsPerUser = (double) commentsQuantity/userQuantity;
        if (Double.isNaN(tempAvgCommentsPerUser)){tempAvgCommentsPerUser = 0.0;}
        this.avgCommentsPerUser = tempAvgCommentsPerUser;

        double tempAvgCommentsPerPost = (double) commentsQuantity/postsQuantity;
        if (Double.isNaN(tempAvgCommentsPerPost)){tempAvgCommentsPerPost = 0.0;};
        this.avgCommentsPerPost = tempAvgCommentsPerPost;
    }

    public void showStatistics(){
        System.out.println(
                "User quantity: " + userQuantity +
                        "\nPosts quantity: " + postsQuantity +
                        "\nComments quantity: " + commentsQuantity +
                        "\navg. posts per User: " + avgPostsPerUser +
                        "\navg. comments per user: " + avgCommentsPerUser +
                        "\navg. comments per post: " + avgCommentsPerPost);
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public int getUserQuantity() {
        return userQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }
}
