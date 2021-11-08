package com.kodilla.patterns.social;

import com.kodilla.patterns.social.SocialMedia.SnapchatPublisher;
import com.kodilla.patterns.social.SocialMedia.TwitterPublisher;

public class ZGeneration extends User{

    public ZGeneration(String name) {
        super(name);
        this.socialPublisher = new SnapchatPublisher();
    }
}
