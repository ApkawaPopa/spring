package minchakov.arkadii.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    private String hello(
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "surname", required = false) String surname,
        Model model
    ) {
        model.addAttribute("greeting", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    private String goodbye() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    private String calculator(
        @RequestParam("a") int a,
        @RequestParam("b") int b,
        @RequestParam("action") String action,
        Model model
    ) {
        double calculatedResult = switch (action) {
            case "add" -> a + b;
            case "sub" -> a - b;
            case "mul" -> a * b;
            case "div" -> a / (double) b;
            default -> 0;
        };

        model.addAttribute("calculatedResult", calculatedResult);

        return "first/calculator";
    }
}
