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
    private boolean userExists = false;
    private boolean emailExists = false;
    private boolean passwordsMatch = true;


    public UserController(UserRepository users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("userExists",userExists);
        model.addAttribute("emailExists",emailExists);
        model.addAttribute("passwordsMatch",passwordsMatch);
        System.out.println(passwordsMatch);
        model.addAttribute("user", new User());
        this.passwordsMatch = true;
        this.emailExists = false;
        this.userExists = false;
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user, @RequestParam String password, @RequestParam String confirmpassword, @RequestParam String username, @RequestParam String email) {
        this.userExists = users.findByUsername(username) != null;
        this.emailExists = users.findByEmail(email) != null;
        if(userExists || emailExists){
            return "redirect:/sign-up";
        }
        if (password.equals(confirmpassword)) {
            String hash = passwordEncoder.encode(user.getPassword());
            user.setPassword(hash);
            users.save(user);
            return "redirect:/login";
        } else {
            this.passwordsMatch = password.equals(confirmpassword);
            System.out.println(passwordsMatch);
            return "redirect:/sign-up";
        }

    }
    @GetMapping("/users/{id}/edit")
    public String editProfile(@PathVariable Long id, Model vModel){
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            return"redirect:/login";
        } else {
            User loggedInUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(loggedInUser.getId() != id){
                return"redirect:/";
            }
        }
        vModel.addAttribute("userExists",userExists);
        vModel.addAttribute("emailExists",emailExists);
        vModel.addAttribute("passwordsMatch", passwordsMatch);
        vModel.addAttribute("user",users.findOne(id));
        this.passwordsMatch = true;
        this.emailExists = false;
        this.userExists = false;
        return "users/edit";
    }
    @PostMapping("/users/{id}/edit")
    public String updateProfile(@ModelAttribute User user, @PathVariable Long id, @RequestParam String newpassword,@RequestParam String confirmpassword, @RequestParam String email, @RequestParam String username){
        User loggedInUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.userExists = users.findByUsername(username) != null && users.findByUsername(username).getId() != loggedInUser.getId();
        this.emailExists = users.findByEmail(email) != null && users.findByEmail(email).getId() != loggedInUser.getId();
        this.passwordsMatch = confirmpassword.equals(newpassword);
        if(userExists || emailExists){
            return "redirect:/users/" + id + "/edit";
        }
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
            return "redirect:/users/" + id + "/edit";
        }
    }
}
