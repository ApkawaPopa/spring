package minchakov.arkadii.spring.controller;

import minchakov.arkadii.spring.dao.PersonDAO;
import minchakov.arkadii.spring.model.Person;
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

    @GetMapping
    public String index(Model model, @ModelAttribute Person person) {
        model.addAttribute("people", personDAO.findAll());
        return "admin/index";
    }

    @PatchMapping("/set")
    public String set(@ModelAttribute Person person) {
        System.out.println("New administrator id: " + person.getId());
        return "redirect:/people";
    }
}
