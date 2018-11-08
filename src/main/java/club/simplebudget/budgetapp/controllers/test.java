package club.simplebudget.budgetapp.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class test {
    @GetMapping("/")
    public String Landing(){
        return "homepage";
    }
}
