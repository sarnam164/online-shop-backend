package com.ssb.onlineshopbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Home {

    @RequestMapping("/welcome")
    public String welcome(){
        String text = "Hello";
        return text;
    }

    @RequestMapping("/getusers")
    public String getUsers(){
        return "{\"username\":\"Sayed\"}";
    }
}
