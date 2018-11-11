package club.simplebudget.budgetapp.controllers;

import club.simplebudget.budgetapp.models.Comment;
import club.simplebudget.budgetapp.models.Post;
import club.simplebudget.budgetapp.models.User;
import club.simplebudget.budgetapp.repositories.PostRepository;
import club.simplebudget.budgetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/posts")
    public String posts(Model model){
        model.addAttribute("posts",postRepository.findAll());
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model){
        model.addAttribute("Post",postRepository.findOne(id));
        return "posts/show";
    }
    @GetMapping("/posts/create")
    public String createPostIndex(Model model){
        model.addAttribute("post",new Post());
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(loggedInUser == null){
            return "redirect:/login";
        }
        post.setUser(userRepository.findOne(loggedInUser.getId()));
        postRepository.save(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(postRepository.findOne(id) != null && postRepository.findOne(id).getUser().getId() == loggedInUser.getId()) {
            model.addAttribute("post", postRepository.findOne(id));
            return "posts/edit";
        } else {
            return "redirect:/";
        }
    }
    @PostMapping("/posts/{id}/edit")
    public String submitEdit(@ModelAttribute Post post, @PathVariable long id) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (postRepository.findOne(id).getUser().getId() == loggedInUser.getId()) {
            post.setUser(userRepository.findByUsername(loggedInUser.getUsername()));
            postRepository.save(post);
            return "redirect:/posts";
        } else {
            return "redirect:/";
        }
    }
    @PostMapping("/posts/{id}/delete")
    public String deletePost(@ModelAttribute Post post, @PathVariable long id){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (postRepository.findOne(id).getUser().getId() == loggedInUser.getId()) {
        postRepository.delete(post);
        return "redirect:/posts";
        } else {
            return "redirect:/";
        }

    }
}