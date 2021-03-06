package club.simplebudget.budgetapp.controllers;


import club.simplebudget.budgetapp.repositories.PostRepository;
import club.simplebudget.budgetapp.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/")
    public String homepage(Model model){
        model.addAttribute("reviews",reviewRepository.findTop3ByOrderByIdDesc());
        return "homepage";
    }
    @GetMapping("/faq")
    public String faqPage(){
        return "faq";
    }

    @GetMapping("/about-team")
    public String aboutUs(){
        return "about-team";
    }
    @GetMapping("/supincome")
    public String supPage(){
        return "supincome";
    }
    @GetMapping("/search")
    public String search(@RequestParam String search, Model model){
        model.addAttribute("posts",postRepository.findAllByTitleContainsOrBodyContains(search,search));
        return "posts/index";
    }
}
