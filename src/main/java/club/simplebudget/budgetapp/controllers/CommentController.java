package club.simplebudget.budgetapp.controllers;

import club.simplebudget.budgetapp.models.Comment;
import club.simplebudget.budgetapp.models.User;
import club.simplebudget.budgetapp.repositories.CommentRepository;
import club.simplebudget.budgetapp.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    @GetMapping("/comment/create/{id}")
    public String makeComment(@PathVariable long id, Model model, @ModelAttribute Comment newComment) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return"posts/show";
    }

    @PostMapping("/comment/{id}")
        public String postComment(@PathVariable long id, Model model, @ModelAttribute Comment newComment){
            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        newComment.setUser(loggedInUser);
        newComment.setPost(postRepository.findOne(id));
        commentRepository.save(newComment);
        return "posts/show";

    }
}
