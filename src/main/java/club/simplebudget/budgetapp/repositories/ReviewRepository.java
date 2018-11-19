package club.simplebudget.budgetapp.repositories;


import club.simplebudget.budgetapp.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    Review findByUser_Id(long user_id);
}
