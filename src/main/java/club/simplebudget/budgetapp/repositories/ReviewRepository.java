package club.simplebudget.budgetapp.repositories;


import club.simplebudget.budgetapp.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

}
