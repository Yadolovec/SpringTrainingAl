package com.app.controller;

import com.app.DAO.PersonDAO;
import com.app.models.Person;
import com.app.services.ItemsService;
import com.app.services.PeopleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;
    private final ItemsService itemsService;

    private final PersonDAO personDAO;

    public PeopleController(PeopleService peopleService, ItemsService itemsService, PersonDAO personDAO) {
        this.peopleService = peopleService;
        this.itemsService = itemsService;
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", peopleService.findAll());
        personDAO.nPlusOnePr();
        itemsService.findByItemName("Airpods");
        itemsService.findByOwner(peopleService.findAll().get(0));
        peopleService.test();

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
        peopleService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){

        model.addAttribute("person", peopleService.findOne(id));
        return "people/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("person", peopleService.findOne(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String edited(@PathVariable("id") int id, @ModelAttribute Person person) {
        peopleService.update(id, person);
        return "redirect:/people/"+id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        peopleService.delete(id);
        return "redirect:/people";
    }

}

//<form th:method="POST" th:action="@{/people}" th:object="${person}">
//<label for="name">Enter name: </label>
//<br/>
//<div style="color:red" th:if="${#fields.hasErrors('name')}" th:errors="*{name}">Name error</div>
//<input type="text" th:field="*{name}" id="name"/>
//<br/>
