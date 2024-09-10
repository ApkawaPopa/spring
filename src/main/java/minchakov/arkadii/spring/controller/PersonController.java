package minchakov.arkadii.spring.controller;

import minchakov.arkadii.spring.dao.PersonDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PersonController {
    private final PersonDAO personDAO;

    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    private String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "person/index";
    }

    @GetMapping("/{id}")
    private String show(@PathVariable int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "person/show";
    }
}
