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
    @Column
    private Double savings;
    @Column(nullable = false, name = "choice")
    private long option;
    @OneToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
    private List<Bill> bills;

    public Account() {
    }

    public Account(long id, Double income, Double savings, User user, List<Bill> bills, long option) {
        this.id = id;
        this.income = income;
        this.savings = savings;
        this.user = user;
        this.bills = bills;
        this.option = option;
    }

    public Account(Double income, Double savings, long option, User user, List<Bill> bills) {
        this.income = income;
        this.savings = savings;
        this.option = option;
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

    public long getOption() {
        return option;
    }

    public void setOption(long option) {
        this.option = option;
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
