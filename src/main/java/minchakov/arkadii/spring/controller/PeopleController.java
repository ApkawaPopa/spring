package minchakov.arkadii.spring.controller;

import minchakov.arkadii.spring.dao.PersonDAO;
import minchakov.arkadii.spring.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    private String index(Model model) {
        model.addAttribute("people", personDAO.findAll());
        return "people/index";
    }

    @GetMapping("/{id}")
    private String show(@PathVariable int id, Model model) {
        model.addAttribute("person", personDAO.find(id));
        return "people/show";
    }

    @GetMapping("/new")
    private String create(@ModelAttribute("person") Person person) {
        return "people/create";
    }

    @PostMapping
    private String insert(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/create";
        }

        personDAO.add(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    private String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.find(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    private String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        personDAO.update(person);
        return "redirect:/people/" + person.getId();
    }

    @DeleteMapping("/{id}")
    private String delete(@PathVariable int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}