package io.maslick.apps7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Servis {

    @Autowired List<AdNetwork> networks;

    public void run(String date) {
        networks.forEach(n -> {
            n.setDate(date);
            n.run();
        });
    }
}