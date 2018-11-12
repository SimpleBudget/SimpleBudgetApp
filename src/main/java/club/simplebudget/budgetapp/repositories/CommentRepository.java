package club.simplebudget.budgetapp.repositories;


import club.simplebudget.budgetapp.models.Comment;
import club.simplebudget.budgetapp.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAllByCommentId(Comment comment);

}