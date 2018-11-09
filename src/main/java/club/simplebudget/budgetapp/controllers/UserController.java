package club.simplebudget.budgetapp.controllers;

import club.simplebudget.budgetapp.models.User;
import club.simplebudget.budgetapp.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private UserRepository users;
    private PasswordEncoder passwordEncoder;


    public UserController(UserRepository users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user, @RequestParam String password, @RequestParam String confirmpassword) {
        if (password.equals(confirmpassword)) {
            String hash = passwordEncoder.encode(user.getPassword());
            user.setPassword(hash);
            users.save(user);
            return "redirect:/login";
        } else {
            return "redirect:/sign-up";
        }

    }
    @GetMapping("/users/{id}/edit")
    public String editProfile(@PathVariable Long id, Model vModel){
        vModel.addAttribute("user",users.findOne(id));
        return "users/edit";
    }
    @PostMapping("/users/{id}/edit")
    public String updateProfile(@ModelAttribute User user, @PathVariable Long id, @RequestParam String newpassword,@RequestParam String confirmpassword){
        User loggedInUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(users.findOne(id).getId() == loggedInUser.getId() && !newpassword.equals("")&& confirmpassword.equals(newpassword)) {
            String hash = passwordEncoder.encode(newpassword);
            user.setPassword(hash);
            users.save(user);
            return "redirect:/profile";
        }else if(users.findOne(id).getId() == loggedInUser.getId() && newpassword.equals("")){
            user.setPassword(loggedInUser.getPassword());
            users.save(user);
            return "redirect:/profile";
        } else {
            return "redirect:/";
        }
    }
}
