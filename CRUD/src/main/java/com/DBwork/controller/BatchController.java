package com.DBwork.controller;

import com.DBwork.dao.PersonDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/batch-update-test")
public class BatchController {
    private final PersonDAO personDAO;

    public BatchController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(){
        return "batch/index";
    }

    @GetMapping("/without")
    public String withoutBatch(){
        personDAO.add1000withoutBatch();
        return "redirect:/people";
    }

    @GetMapping("/with")
    public String withBatch(){
        personDAO.add1000withBatch();
        return "redirect:/people";
    }




}
