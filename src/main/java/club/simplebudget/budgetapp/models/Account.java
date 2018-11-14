package club.simplebudget.budgetapp.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private Double income;
    @Column(nullable = false)
    private Double savings;
    @OneToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
    private List<Bill> bills;

    public Account() {
    }

    public Account(long id, Double income, Double savings, User user, List<Bill> bills) {
        this.id = id;
        this.income = income;
        this.savings = savings;
        this.user = user;
        this.bills = bills;
    }

    public Account(Double income, Double savings, User user, List<Bill> bills) {
        this.income = income;
        this.savings = savings;
        this.user = user;
        this.bills = bills;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getSavings() {
        return savings;
    }

    public void setSavings(Double savings) {
        this.savings = savings;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
