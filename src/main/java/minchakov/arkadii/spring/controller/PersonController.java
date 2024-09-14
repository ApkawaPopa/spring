package minchakov.arkadii.spring.controller;

import minchakov.arkadii.spring.dao.PersonDAO;
import minchakov.arkadii.spring.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PersonController {
    private final PersonDAO personDAO;

    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    private String index(Model model) {
        model.addAttribute("people", personDAO.findAll());
        return "person/index";
    }

    @GetMapping("/{id}")
    private String show(@PathVariable int id, Model model) {
        model.addAttribute("person", personDAO.find(id));
        return "person/show";
    }

    @GetMapping("/new")
    private String create(@ModelAttribute("person") Person person) {
        return "person/create";
    }

    @PostMapping
    private String insert(@ModelAttribute("person") Person person) {
        personDAO.add(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    private String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.find(id));
        return "person/edit";
    }

    @PatchMapping("/{id}")
    private String update(@ModelAttribute("person") Person person) {
        personDAO.update(person);
        return "redirect:/people/" + person.getId();
    }

    @DeleteMapping("/{id}")
    private String delete(@PathVariable int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
