package ec.tcs.springcrud.controllers;

import ec.tcs.springcrud.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(path = "/people")
    public String getPeople(Model model) {
        var people = personService.listPeople();
        log.info("Run controller");
        model.addAttribute("people", people);
        return "index";
    }
}
