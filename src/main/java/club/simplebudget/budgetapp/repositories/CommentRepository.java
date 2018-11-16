package club.simplebudget.budgetapp.repositories;


import club.simplebudget.budgetapp.models.Comment;
import club.simplebudget.budgetapp.models.Post;
import club.simplebudget.budgetapp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAllByCommentId(Comment comment);
    List<Comment> findAllByPost(Post post);
    List<Comment> findAllByUser(User user);
    @Override
    ArrayList<Comment> findAll();

}