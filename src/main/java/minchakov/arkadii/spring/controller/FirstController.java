package minchakov.arkadii.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    private String hello() {
        return "first/hello";
    }

    @GetMapping("/goodbye")
    private String goodbye() {
        return "first/goodbye";
    }
}
