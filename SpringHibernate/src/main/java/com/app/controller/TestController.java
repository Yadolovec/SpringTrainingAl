package com.app.controller;

import com.app.DAO.PersonDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    private final PersonDAO personDAO;

    public TestController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/test")
    public String tesst(){
        return "test";
    }

    @GetMapping("/people")
    public String people(Model model){
        model.addAttribute("people", personDAO.index());
        return "people";
    }
}
