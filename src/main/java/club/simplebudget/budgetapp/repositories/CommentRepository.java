package club.simplebudget.budgetapp.repositories;


import club.simplebudget.budgetapp.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
//    List<Comment> findAllByPosts_Id(long post_id);
//    List<Comment> findAllByCommentId_Id(long comment_id);
}