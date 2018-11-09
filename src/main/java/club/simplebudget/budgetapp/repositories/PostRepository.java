package club.simplebudget.budgetapp.repositories;


import club.simplebudget.budgetapp.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAllByUser_Id(long user_id);
}