package com.MCNOne.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String hello(){
        return "first/hello";
    }

    @GetMapping ("/goodbye")
    public String goodBye(){
        return "first/goodBye";
    }
}
