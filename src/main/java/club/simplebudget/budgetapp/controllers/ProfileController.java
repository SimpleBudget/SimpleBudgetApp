package club.simplebudget.budgetapp.controllers;
import club.simplebudget.budgetapp.models.User;
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


    @GetMapping("/profile")
    public String ProfileController(Model model){
        User loggedInUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userRepository.findOne(loggedInUser.getId()));
        return "users/profile";
    }
}
