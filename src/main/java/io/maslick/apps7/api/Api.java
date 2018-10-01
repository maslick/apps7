package io.maslick.apps7.api;

import io.maslick.apps7.service.Servis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {
    @Autowired
    private Servis servis;

    @PostMapping("/fetchData")
    public String fetch(@RequestParam String date) {
        servis.run(date);
        return "OK";
    }
}
