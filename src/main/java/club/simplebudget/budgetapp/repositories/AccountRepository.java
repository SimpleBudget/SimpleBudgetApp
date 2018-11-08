package club.simplebudget.budgetapp.repositories;


import club.simplebudget.budgetapp.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}