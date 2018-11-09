package club.simplebudget.budgetapp.models;
import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private long income;
    @Column(nullable = false)
    private long savings;
    @OneToOne
    private User user;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Bill bill;

    public Account() {
    }

    public Account(long id, long income, long savings, User user, Bill bill) {
        this.id = id;
        this.income = income;
        this.savings = savings;
        this.user = user;
        this.bill = bill;
    }

    public Account(long income, long savings, User user, Bill bill) {
        this.income = income;
        this.savings = savings;
        this.user = user;
        this.bill = bill;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    public long getSavings() {
        return savings;
    }

    public void setSavings(long savings) {
        this.savings = savings;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
