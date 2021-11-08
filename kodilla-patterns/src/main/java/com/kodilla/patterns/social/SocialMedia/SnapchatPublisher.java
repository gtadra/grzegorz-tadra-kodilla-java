package com.kodilla.patterns.social.SocialMedia;

import com.kodilla.patterns.social.SocialPublisher;

public class SnapchatPublisher implements SocialPublisher {

    @Override
    public String share() {
        return "Snapchat";
    }
}
