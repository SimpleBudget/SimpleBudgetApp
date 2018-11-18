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
import org.springframework.web.bind.annotation.*;
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
    public String accountsetup(Model model) {
        User loggedInUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("LOOK HERE");
//        System.out.println(accountRepository.findAccountByUser_Id(loggedInUser.getId()));
        if(accountRepository.findAccountByUser_Id(loggedInUser.getId()) != null) {
            Account userAccount = accountRepository.findAccountByUser_Id(loggedInUser.getId());
            model.addAttribute("account", userAccount);
        }
        model.addAttribute("bill", new Bill());
        List<Bill> allUserBills =  billRepository.findAllByUser_Id(loggedInUser.getId());
        if(billRepository.findAllByUser_Id(loggedInUser.getId()) != null) {
            model.addAttribute("bills", allUserBills);
        }
        double billTotal = 0;
        model.addAttribute("billTotal", billTotal);
            for (Bill bill1 : allUserBills) {
                billTotal += bill1.getAmount();
            }
        return "users/account-setup";
    }

    @PostMapping("/account-setup")
    public String makeaccount(@ModelAttribute Bill bill,
                              @RequestParam(required = false) String monthlyincome,
                              @RequestParam(required = false) String exampleRadios1,
                              @RequestParam(required = false) Double savingsoverall,Model model) {
        Double monthlyincomeDouble = 0.00;
        if(monthlyincome != null && !monthlyincome.equals("")) {
             monthlyincomeDouble = Double.parseDouble(monthlyincome);
        }
        User loggedInUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Bill> userBills = billRepository.findAllByUser_Id(loggedInUser.getId());
        Account userAccount = accountRepository.findAccountByUser_Id(loggedInUser.getId());
        if(userAccount == null){
            userAccount = new Account();
        }

        if (exampleRadios1.equals("option1")) {
            Double sum = monthlyincomeDouble * 4;
//            model.addAttribute("sum", sum);
            userAccount.setIncome(sum);
            userAccount.setUser(loggedInUser);
            userAccount.setSavings(savingsoverall);
            userAccount.setBills(userBills);
            userAccount.setOption(1);
            accountRepository.save(userAccount);
            return "redirect:/profile";
        } else if (exampleRadios1.equals("option2")) {
            Double sum1 = monthlyincomeDouble * 2;
//            model.addAttribute("sum1", sum1);
            userAccount.setIncome(sum1);
            userAccount.setUser(loggedInUser);
            userAccount.setSavings(savingsoverall);
            userAccount.setBills(userBills);
            userAccount.setOption(2);
            accountRepository.save(userAccount);
            return "redirect:/profile";
        } else  {
//            model.addAttribute("monthlyincomelong", monthlyincomeDouble);
            userAccount.setIncome(monthlyincomeDouble);
            userAccount.setUser(loggedInUser);
            userAccount.setSavings(savingsoverall);
            userAccount.setBills(userBills);
            userAccount.setOption(3);
            accountRepository.save(userAccount);
            return "redirect:/profile";
        }

    }

    @PostMapping("/addBill")
    public String addBill(@ModelAttribute Account account, @ModelAttribute Bill bill, @RequestParam String billname,
                          @RequestParam Double billamount, @RequestParam(required = false) String savings, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Double savingsDouble = 0.00;
        if(!savings.equals("")) {
            savingsDouble = Double.parseDouble(savings);
        }
        if(billRepository.findByUserAndName(loggedInUser,"What you want to save") == null && !savings.equals("")){
            Bill savingsBill = new Bill();
            savingsBill.setName("What you want to save");
            savingsBill.setAmount(savingsDouble);
            savingsBill.setUser(loggedInUser);
            billRepository.save(savingsBill);
        } else if(billRepository.findByUserAndName(loggedInUser,"What you want to save") != null && !savings.equals("")){
            Bill savingsBill = billRepository.findByUserAndName(loggedInUser,"What you want to save");
            savingsBill.setAmount(savingsDouble);
            billRepository.save(savingsBill);
        }
        if(!billname.equals("") && billamount != null) {
            bill.setName(billname);
            bill.setAmount(billamount);
            bill.setAccount(accountRepository.findAccountByUser_Id(loggedInUser.getId()));
            bill.setUser(loggedInUser);
            billRepository.save(bill);
        }
        return "redirect:/account-setup";
    }
    @PostMapping("/bill/{id}")
    public String deleteBill(@PathVariable long id){
        billRepository.delete(billRepository.findOne(id));
        return "redirect:/account-setup";
    }

}

