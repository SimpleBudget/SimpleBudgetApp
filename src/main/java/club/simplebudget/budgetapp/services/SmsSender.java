package club.simplebudget.budgetapp.services;

import club.simplebudget.budgetapp.models.Comment;
import club.simplebudget.budgetapp.models.Post;
import club.simplebudget.budgetapp.models.User;
import club.simplebudget.budgetapp.repositories.CommentRepository;
import club.simplebudget.budgetapp.repositories.PostRepository;
import club.simplebudget.budgetapp.repositories.UserRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class SmsSender {

    @Autowired
    private  PostRepository postRepository;
    @Autowired
    private  CommentRepository commentRepository;
    @Autowired
    private  UserRepository userRepository;



    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC4cdef43bb712831c1a5255d424d0bb31";
    public static final String AUTH_TOKEN =
            "5e8a0c345703fcec157b9e9216105e76";

    public String send() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        if (userRepository.findAll() != null) {
            Iterable<User> usersWithPhonenumber = userRepository.findAll();
            for (User user : usersWithPhonenumber) {
                if (user.getPhonenumber().equals("+12146775272")) {
                    List<Post> userPosts = postRepository.findAllByUser_Id(user.getId());
                    for (Post post : userPosts) {
                        ArrayList<Comment> comments = commentRepository.findAll();
                        for (int i = comments.size()-1; i > 0; i--) {
                            if (comments.get(i).getPost() != null && comments.get(i).getUser().getId() != user.getId()) {
                                Message message = Message
                                        .creator(new PhoneNumber("+12146775272"), // to
                                                new PhoneNumber("+18177847631"), // from
                                                "You have gotten a new comment on your post!")
                                        .create();

                                return (message.getSid());
                            } else {
                                return"";
                            }
                        }
                    }
                }
            }
        }
//        Message message = Message
//                .creator(new PhoneNumber("+12146775272"), // to
//                        new PhoneNumber("+18177847631"), // from
//                        "Where's Wallace?")
//                .create();
//
//        System.out.println(message.getSid());
   return ""; }
   public String sendReply(){
       Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
       if (userRepository.findAll() != null) {
           Iterable<User> usersWithPhonenumber = userRepository.findAll();
           for (User user : usersWithPhonenumber) {
               if (user.getPhonenumber().equals("+12146775272")) {
                   List<Post> userPosts = postRepository.findAllByUser_Id(user.getId());
                   for (Post post : userPosts) {
                       ArrayList<Comment> comments = commentRepository.findAll();
                       for (int i = comments.size()-1; i > 0; i--) {
                           if (comments.get(i).getCommentId() != null && comments.get(i).getUser().getId() != user.getId() && user.getId() == comments.get(i).getCommentId().getUser().getId()) {
                               Message message = Message
                                       .creator(new PhoneNumber("+12146775272"), // to
                                               new PhoneNumber("+18177847631"), // from
                                               "You have gotten a new reply on your comment!")
                                       .create();

                               return (message.getSid());
                           } else {
                               return"";
                           }
                       }
                   }
               }
           }
       }
   return "";}
}

