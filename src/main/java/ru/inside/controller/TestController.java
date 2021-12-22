package ru.inside.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    public static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/user/get")
    public String getUser() {
        return "Hi user";
    }

    @PostMapping("/user/gettoken")
    public void getToken(){

    }
}
