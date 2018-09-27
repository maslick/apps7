package io.maslick.apps7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Servis {

    @Autowired
    @Qualifier("superNetwork")
    AdNetwork superNetwork;

    @Autowired
    @Qualifier("adUmbrella")
    AdNetwork adUmbrella;

    public void run(String date) {
        superNetwork.setDate(date);
        superNetwork.run();

        adUmbrella.setDate(date);
        adUmbrella.run();
    }
}