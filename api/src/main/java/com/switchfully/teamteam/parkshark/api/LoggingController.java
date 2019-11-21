package com.switchfully.teamteam.parkshark.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoggingController {

    @RequestMapping("/")
    public String index() {
        return "Check the logs to see the output.";
    }
}
