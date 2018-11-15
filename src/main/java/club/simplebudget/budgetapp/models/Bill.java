package club.simplebudget.budgetapp.models;
import javax.persistence.*;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double amount;
    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    private User user;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    public Bill() {
    }

    public Bill(long id, String name, Double amount, User user, Account account) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.user = user;
        this.account = account;
    }

    public Bill(String name, Double amount, User user, Account account) {
        this.name = name;
        this.amount = amount;
        this.user = user;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
