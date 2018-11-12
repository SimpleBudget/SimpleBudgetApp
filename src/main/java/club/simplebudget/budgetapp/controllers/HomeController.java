package club.simplebudget.budgetapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homepage(){
        return "homepage";
    }
    @GetMapping("/faq")
    public String faqPage(){
        return "faq";
    }

    @GetMapping("/about-team")
    public String aboutUs(){
        return "about-team";
    }
    @GetMapping("/supincome")
    public String supPage(){
        return "supincome";
    }
    @GetMapping("/reviews")
    public String reviews(){
        return "reviews";
    }
}
