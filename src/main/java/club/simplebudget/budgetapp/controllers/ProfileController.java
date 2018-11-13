package club.simplebudget.budgetapp.controllers;
import club.simplebudget.budgetapp.models.User;
import club.simplebudget.budgetapp.repositories.AccountRepository;
import club.simplebudget.budgetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ProfileController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;


    @GetMapping("/profile")
    public String ProfileController(Model model){
        User loggedInUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findByUsername(loggedInUser.getUsername());
        model.addAttribute("user",userRepository.findOne(loggedInUser.getId()));
        model.addAttribute("account", accountRepository.findAccountByUser_Id(currentUser.getId()));
        return "users/profile";
    }
}
