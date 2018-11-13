package club.simplebudget.budgetapp.controllers;


import club.simplebudget.budgetapp.models.Account;
import club.simplebudget.budgetapp.models.Bill;
import club.simplebudget.budgetapp.models.User;
import club.simplebudget.budgetapp.repositories.AccountRepository;
import club.simplebudget.budgetapp.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BillRepository billRepository;

    @GetMapping("/account-setup")
    public String accountsetup(Model model, Model model1){
        model.addAttribute("account", new Account());
        model1.addAttribute("bill", new Bill());
        return "users/account-setup";
    }

    @PostMapping("/account-setup")
    public String makeaccount(@ModelAttribute Account account, @ModelAttribute Bill bill, @RequestParam(required = false) String monthlyincome,
                              @RequestParam(required = false) String exampleRadios1, @RequestParam(required = false) String billname,
                              @RequestParam(required = false) Double billamount, @RequestParam(required = false) Long savingsoverall,
                              @RequestParam(required = false) Long savings, Model model) {
       Long monthlyincomelong = Long.parseLong(monthlyincome);
        User loggedInUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        if (exampleRadios1.equals("option1")) {
            List<Bill> bills = new ArrayList<>();
            long sum = monthlyincomelong * 4;
            model.addAttribute("sum", sum);
            account.setIncome(sum);
            account.setUser(loggedInUser);
            account.setSavings(savingsoverall);
            accountRepository.save(account);
            bill.setName(billname);
            bill.setAmount(billamount);
            bill.setAccount(account);
            bill.setUser(loggedInUser);
            billRepository.save(bill);
            bills.add(bill);
            account.setBills(bills);
            return "redirect:/profile";
        } else if (exampleRadios1.equals("option2")) {
            long sum1 = monthlyincomelong * 2;
            model.addAttribute("sum1", sum1);
            account.setIncome(sum1);
            account.setUser(loggedInUser);
            account.setSavings(savingsoverall);
            accountRepository.save(account);
            bill.setName(billname);
            bill.setAmount(billamount);
            bill.setAccount(account);
            bill.setUser(loggedInUser);
            billRepository.save(bill);

            return "redirect:/profile";
        } else  {
            model.addAttribute("monthlyincomelong", monthlyincomelong);
            account.setIncome(monthlyincomelong);
            account.setUser(loggedInUser);
            account.setSavings(savingsoverall);
            accountRepository.save(account);
            bill.setName(billname);
            bill.setAmount(billamount);
            bill.setAccount(account);
            bill.setUser(loggedInUser);
            billRepository.save(bill);

            return "redirect:/profile";
        }



    }
}

