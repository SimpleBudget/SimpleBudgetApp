package club.simplebudget.budgetapp.repositories;
import club.simplebudget.budgetapp.models.Bill;
import club.simplebudget.budgetapp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {
    List<Bill> findAllByUser_Id(long user_id);
    Bill findByName(String name);
    Bill findByUserAndName(User user, String name);

}