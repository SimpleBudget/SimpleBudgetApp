package club.simplebudget.budgetapp.controllers;


import club.simplebudget.budgetapp.models.Account;
import club.simplebudget.budgetapp.models.Bill;
import club.simplebudget.budgetapp.models.User;
import club.simplebudget.budgetapp.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.sun.tools.doclint.Entity.sum;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/account-setup")
    public String accountsetup(Model model, Model model1){
        model.addAttribute("account", new Account());
        model1.addAttribute("bill", new Bill());
        return "users/account-setup";
    }

    @PostMapping("/account-setup")
    public String makeaccount(@ModelAttribute Account account, @ModelAttribute Bill bill,  @RequestParam(required = false) String monthlyincome,
                              @RequestParam(required = false) String exampleRadios1, @RequestParam(required = false) String exampleRadios2, @RequestParam(required = false) String
                              exampleRadios3, @RequestParam(required = false) Double bills, @RequestParam(required = false) Long savingsoverall, @RequestParam(required = false) Long savings, Model model) {
       Long monthlyincomelong = Long.parseLong(monthlyincome);
        User loggedInUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        if (exampleRadios1.equals("option1")) {
            long sum = monthlyincomelong * 4;
            model.addAttribute("sum", sum);
            account.setIncome(sum);
            account.setUser(loggedInUser);
            account.setSavings(savingsoverall);
            accountRepository.save(account);


            return "redirect:/profile";
        } else if (exampleRadios1.equals("option2")) {
            long sum1 = monthlyincomelong * 2;
            model.addAttribute("sum1", sum1);
            account.setIncome(sum1);
            account.setUser(loggedInUser);
            account.setSavings(savingsoverall);
            accountRepository.save(account);
            return "redirect:/profile";
        } else  {
            model.addAttribute("monthlyincomelong", monthlyincomelong);
            account.setIncome(monthlyincomelong);
            account.setUser(loggedInUser);
            account.setSavings(savingsoverall);
            accountRepository.save(account);
            return "redirect:/profile";
        }



    }
}

