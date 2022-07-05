package ec.tcs.springcrud.controllers;

import ec.tcs.springcrud.entities.Person;
import ec.tcs.springcrud.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(path = "/")
    public String getPeople(Model model) {
        var people = personService.listPeople();
        log.info("Run controller");
        model.addAttribute("people", people);
        return "index";
    }

    @GetMapping(path = "/add")
    public String add(Person person) {
        return "update";
    }

    @PostMapping(path = "/save")
    public String save(@Valid Person person, Errors errors) {
        if (errors.hasErrors()) {
            return "update";
        }
        personService.save(person);
        return "redirect:/";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(Person person, Model model) {
        person = personService.findPerson(person);
        model.addAttribute("person", person);
        return "update";
    }

    @GetMapping(path = "/delete")
    public String delete(Person person) {
        personService.delete(person);
        return "redirect:/";
    }

}
