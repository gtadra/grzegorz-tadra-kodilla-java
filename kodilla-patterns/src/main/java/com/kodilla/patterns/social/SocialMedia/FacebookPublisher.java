package com.kodilla.patterns.social.SocialMedia;

import com.kodilla.patterns.social.SocialPublisher;

public class FacebookPublisher implements SocialPublisher {

    @Override
    public String share() {
        return "Facebook";
    }


}
