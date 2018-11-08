package club.simplebudget.budgetapp.repositories;


import club.simplebudget.budgetapp.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

}