package club.simplebudget.budgetapp.controllers;

import club.simplebudget.budgetapp.models.Comment;
import club.simplebudget.budgetapp.models.Post;
import club.simplebudget.budgetapp.models.User;
import club.simplebudget.budgetapp.repositories.CommentRepository;
import club.simplebudget.budgetapp.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/comment/{id}")
        public String postComment(@PathVariable long id, @RequestParam String commentbody){
            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Comment newComment = new Comment();
        Post thePost = postRepository.findOne(id);
        newComment.setUser(loggedInUser);
        newComment.setPost(thePost);
        newComment.setCommentbody(commentbody);
        commentRepository.save(newComment);
        thePost.addComment(newComment);
        postRepository.save(thePost);
        return "redirect:/posts/" + id;

    }
}
