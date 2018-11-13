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
        newComment.setCommentbody(commentbody);
        newComment.setUser(loggedInUser);
        newComment.setPost(thePost);
        commentRepository.save(newComment);
        return "redirect:/posts/" + id;

    }
    @PostMapping("/reply/{id}")
    public String reply(@PathVariable long id, @RequestParam String commentreply){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Comment theComment = commentRepository.findOne(id);
        Comment reply = new Comment();
        reply.setCommentbody(commentreply);
        reply.setUser(loggedInUser);
        reply.setCommentId(theComment);
        commentRepository.save(reply);
        return "redirect:/posts/" + theComment.getPost().getId();

    }
    @PostMapping("/comment/{id}/delete")
    public String deleteComment(@ModelAttribute Post post, @PathVariable long id){
        Comment theComment = commentRepository.findOne(id);
        commentRepository.delete(theComment);
        return "redirect:/posts";

    }
    @PostMapping("/comment/{id}/edit")
    public String editComment(@ModelAttribute Post post, @PathVariable long id, @RequestParam String commentedit){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Comment theComment = commentRepository.findOne(id);
        if(theComment.getCommentId() == null){
            theComment.setUser(loggedInUser);
            theComment.setCommentbody(commentedit);
            theComment.setPost(theComment.getPost());
            commentRepository.save(theComment);
            return "redirect:/posts/"+ theComment.getPost().getId();
        } else {
            theComment.setUser(loggedInUser);
            theComment.setCommentbody(commentedit);
            theComment.setCommentId(theComment.getCommentId());
            commentRepository.save(theComment);
            return "redirect:/posts";
        }
    }

}
