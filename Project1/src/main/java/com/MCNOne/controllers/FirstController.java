package com.MCNOne.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
                          @RequestParam(value="surename", required = false) String surename,
                          Model model){
        model.addAttribute("message","Bye you, "+name+" "+surename+"!?");
        return "first/goodBye";
    }

    @GetMapping("/calculator")
    public String calculator(HttpServletRequest request, Model model){
        float a = Float.parseFloat(request.getParameter("a"));
        float b = Float.parseFloat(request.getParameter("b"));
        String action = request.getParameter("action");
        String answer = doCalc(a,b,action);
        model.addAttribute("answer", answer);

        return "first/calculator";
    }

    public String doCalc(float a, float b, String action){
        if (action.equals("divide")){
            return a+"/"+b+"="+(a/b);
        } else
        if (action.equals("plus")){
            return a+"+"+b+"="+(a+b);
        } else
        if (action.equals("minus")){
            return a+"-"+b+"="+(a-b);
        } else
        if (action.equals("multiple")){
            return a+"*"+b+"="+(a*b);
        } else return "error, no such action";
    }
}
