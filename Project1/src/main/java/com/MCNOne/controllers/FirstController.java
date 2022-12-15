package com.MCNOne.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        String name = request.getParameter("name");
        String surename = request.getParameter("surename");
        System.out.println("Hello you, "+name+" "+surename+"!?");
        return "first/hello";
    }

    @GetMapping ("/goodbye")
    public String goodBye(@RequestParam(value="name", required = false) String name,
                          @RequestParam(value="surename", required = false) String surename){
        System.out.println("Bye you, "+name+" "+surename+"!?");
        return "first/goodBye";
    }
}
