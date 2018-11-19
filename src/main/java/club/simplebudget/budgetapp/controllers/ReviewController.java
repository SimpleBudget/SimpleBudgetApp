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

@Controller
public class ReviewController {
    @Autowired
   private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/reviews-frame")
    public String reviews(Model model){
        model.addAttribute("reviews",reviewRepository.findAll());
        return "reviews/reviewsframe";
    }

    @GetMapping("/reviews")
    public String reviewsIndex(Model model){
        model.addAttribute("reviews",reviewRepository.findAll());
        return "reviews/index";
    }
//    This is for indvidual reviews which we decided not needed
//    @GetMapping("/reviews/{id}")
//    public String individualReview(@PathVariable long id, Model model){
//        model.addAttribute("reviews",reviewRepository.findOne(id));
//        return "reviews/show";
//    }
    @GetMapping("/reviews/create")
    public String createReviewsIndex(Model model){
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
