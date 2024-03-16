package com.demo.hanbaguni.testController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeMessageController {

    @GetMapping("/hello")
    @ResponseBody
    private String welcomeMessage() {
        return "hello";
    }

}
