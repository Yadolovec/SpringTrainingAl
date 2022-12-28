package com.DBwork.controller;

import com.DBwork.dao.PersonDAO;
import com.DBwork.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final PersonDAO personDAO;
    @Autowired
    public AdminController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    @GetMapping()
    public String adminPage(Model model, @ModelAttribute("person") Person person){

        model.addAttribute("people",personDAO.index());
        return "admin/main";
    }
    @PatchMapping("/add")
    public String add(@ModelAttribute("person") Person person){
        Person personToReturn = personDAO.show(person.getId());
        personToReturn.setName("ADMIN "+personToReturn.getName());

        personDAO.update(person.getId(), personToReturn);
        return "redirect:/people";
    }
}
