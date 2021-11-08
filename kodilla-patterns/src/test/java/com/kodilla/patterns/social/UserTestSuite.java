package com.kodilla.patterns.social;

import com.kodilla.patterns.social.SocialMedia.TwitterPublisher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies(){
        //Given
        Millenials millenials = new Millenials("milenials");
        YGeneration yGeneration = new YGeneration("yGeneration");
        ZGeneration zGeneration = new ZGeneration("zGeneration");
        //When
        //Then
        assertEquals("Facebook", millenials.sharePost());
        assertEquals("Twitter", yGeneration.sharePost());
        assertEquals("Snapchat",zGeneration.sharePost());
    }

    @Test
    void testIndividualSharingStrategy(){
        //Given
        Millenials millenials = new Millenials("milenials");
        //When
        millenials.setSocialPublisher(new TwitterPublisher());
        //Then
        assertEquals("Twitter", millenials.sharePost());
    }
}
