package club.simplebudget.budgetapp.controllers;

import club.simplebudget.budgetapp.models.Post;
import club.simplebudget.budgetapp.models.Review;
import club.simplebudget.budgetapp.models.User;
import club.simplebudget.budgetapp.repositories.ReviewRepository;
import club.simplebudget.budgetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReviewController {
    @Autowired
   private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/reviews")
    public String reviews(Model model){
        if(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("reviews",reviewRepository.findAll());
            if(loggedInUser != null) {
                model.addAttribute("loggedinuser", loggedInUser);
            }
            return "reviews/index";
        } else {
            model.addAttribute("reviews",reviewRepository.findAll());
            User anon = new User();
            anon.setId(0);
            model.addAttribute("loggedinuser", anon);
            return "reviews/index";
        }
    }
//    This is for indvidual reviews which we decided not needed
//    @GetMapping("/reviews/{id}")
//    public String individualReview(@PathVariable long id, Model model){
//        model.addAttribute("reviews",reviewRepository.findOne(id));
//        return "reviews/show";
//    }
    @GetMapping("/reviews/create")
    public String createReviewsIndex(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(reviewRepository.findByUser_Id(loggedInUser.getId()) != null) {
            Review UserReview = reviewRepository.findByUser_Id(loggedInUser.getId());
            return "redirect:/reviews/" + UserReview.getId() + "/edit";
        }
        model.addAttribute("review",new Review());
        return "reviews/create";
}
    @PostMapping("/reviews/create")
    public String createReview(@ModelAttribute Review review){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(loggedInUser == null){
            return "redirect:/login";
        }
        review.setUser(userRepository.findOne(loggedInUser.getId()));
        reviewRepository.save(review);
        return "redirect:/reviews";
    }
    @GetMapping("/reviews/{id}/edit")
    public String editReview(@PathVariable long id, Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(reviewRepository.findOne(id)!= null && reviewRepository.findOne(id).getUser().getId() == loggedInUser.getId()){
            model.addAttribute("review",reviewRepository.findOne(id));
            return "reviews/edit";
        }else {
            return "redirect:/profile";
        }
    }
    @PostMapping("/reviews/{id}/edit")
    public String submitReviewEdit(@ModelAttribute Review review, @PathVariable long id){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (reviewRepository.findOne(id).getUser().getId() == loggedInUser.getId()) {
            review.setUser(userRepository.findByUsername(loggedInUser.getUsername()));
            reviewRepository.save(review);
            return "redirect:/reviews";
        } else {
            return "redirect:/profile";
        }
    }
    @PostMapping("/reviews/{id}/delete")
    public String deleteReview(@ModelAttribute Review review, @PathVariable long id){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (reviewRepository.findOne(id).getUser().getId() == loggedInUser.getId()) {
            reviewRepository.delete(review);
            return "redirect:/reviews";
        } else {
            return "redirect:/profile";
        }

    }
}
