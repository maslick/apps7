package io.maslick.apps7.api;

import io.maslick.apps7.service.Servis;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Api {
    private final Servis servis;

    @PostMapping("/fetchData")
    public String fetch(@RequestParam String date) {
        servis.run(date);
        return "OK";
    }
}
