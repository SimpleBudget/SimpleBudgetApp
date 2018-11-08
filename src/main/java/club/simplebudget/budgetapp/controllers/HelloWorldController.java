package club.simplebudget.budgetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloWorldController {
    @GetMapping("/helloworld")
    public String landingPage() {
        return "posts/helloworld";
    }
}
