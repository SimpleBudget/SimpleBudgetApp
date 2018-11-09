package club.simplebudget.budgetapp.repositories;
import club.simplebudget.budgetapp.models.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

}