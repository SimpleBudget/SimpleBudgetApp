package club.simplebudget.budgetapp.controllers;
import club.simplebudget.budgetapp.models.Account;
import club.simplebudget.budgetapp.models.Bill;
import club.simplebudget.budgetapp.models.User;
import club.simplebudget.budgetapp.repositories.AccountRepository;
import club.simplebudget.budgetapp.repositories.BillRepository;
import club.simplebudget.budgetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BillRepository billRepository;

    @GetMapping("/profile")
    public String ProfileController(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account userAccount = accountRepository.findAccountByUser_Id(loggedInUser.getId());
        model.addAttribute("user", userRepository.findOne(loggedInUser.getId()));
        model.addAttribute("account", accountRepository.findAccountByUser_Id(loggedInUser.getId()));
        List<Bill> allUserBills = billRepository.findAllByUser_Id(loggedInUser.getId());
        double billTotal = 0;
        if (allUserBills != null) {
            model.addAttribute("bills", allUserBills);

            for (Bill bill1 : allUserBills) {
                billTotal += bill1.getAmount();
            }
            model.addAttribute("billTotal", billTotal);
        }
        if (userAccount != null && allUserBills != null) {
            Double MoneyAfterBills = userAccount.getIncome() - billTotal;
            model.addAttribute("moneyAfterBills", MoneyAfterBills);
        }
        return "users/profile";
    }
}
