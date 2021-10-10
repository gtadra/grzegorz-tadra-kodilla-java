package com.kodilla.exception.index;
import java.util.List;

public class IndexExceptionRunner {

    public static void main(String[] args){
        VideoCollection videoCollection = new VideoCollection();
        List<String> collection = videoCollection.getCollection();

        String move = collection.get(0);
        System.out.println(move);

        String anotherMove = collection.get(1);
        System.out.println(anotherMove);

    }
}
