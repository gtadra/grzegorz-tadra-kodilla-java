package com.kodilla.patterns.social;

import com.kodilla.patterns.social.SocialMedia.FacebookPublisher;

public class Millenials extends User{

    public Millenials(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
