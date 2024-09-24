package minchakov.arkadii.spring.controller;

import minchakov.arkadii.spring.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/batch")
public class BatchController {
    private final PersonDAO personDAO;

    @Autowired
    public BatchController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index() {
        return "batch/index";
    }

    @PostMapping("/with_batch")
    public String withBatch(RedirectAttributes attributes) {
        long begin = System.currentTimeMillis();
        personDAO.batchInsert(personDAO.make1000People());
        long time = System.currentTimeMillis() - begin;

        attributes.addFlashAttribute("executionTime", time);

        return "redirect:/people";
    }

    @PostMapping("/without_batch")
    public String withoutBatch(RedirectAttributes attributes) {
        long begin = System.currentTimeMillis();
        personDAO.multipleInsert(personDAO.make1000People());
        long time = System.currentTimeMillis() - begin;

        attributes.addFlashAttribute("executionTime", time);

        return "redirect:/people";
    }
}
