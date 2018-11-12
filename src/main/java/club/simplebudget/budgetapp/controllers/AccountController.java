package club.simplebudget.budgetapp.controllers;


import club.simplebudget.budgetapp.models.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @GetMapping("/account-setup")
    public String accountsetup(Model model){
        model.addAttribute("account", new Account());
        return "users/account-setup";
    }
}

