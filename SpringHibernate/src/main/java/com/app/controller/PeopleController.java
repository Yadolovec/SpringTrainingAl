package com.app.controller;

import com.app.DAO.PersonDAO;
import com.app.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String created(@ModelAttribute Person person){
//        Person person = (Person) model.getAttribute("person");////////////////////DONT WORK
        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String edited(@PathVariable("id") int id, @ModelAttribute Person person) {
        personDAO.update(person);
        return "redirect:/people/"+id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }

}

//<form th:method="POST" th:action="@{/people}" th:object="${person}">
//<label for="name">Enter name: </label>
//<br/>
//<div style="color:red" th:if="${#fields.hasErrors('name')}" th:errors="*{name}">Name error</div>
//<input type="text" th:field="*{name}" id="name"/>
//<br/>
