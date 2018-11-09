package club.simplebudget.budgetapp.models;
import javax.persistence.*;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private Double amount;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;


    public Bill() {
    }

    public Bill(long id, String name, Double amount, User user) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.user = user;
    }

    public Bill(String name, Double amount, User user) {
        this.name = name;
        this.amount = amount;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
