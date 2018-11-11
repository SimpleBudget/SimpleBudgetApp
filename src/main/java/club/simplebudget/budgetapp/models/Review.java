package club.simplebudget.budgetapp.models;
import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String body;
    @Column(nullable = false)
    private long rating;
    @OneToOne(cascade=CascadeType.ALL)
    private User user;

    public Review() {
    }

    public Review(long id, String body, long rating, User user) {
        this.id = id;
        this.body = body;
        this.rating = rating;
        this.user = user;
    }

    public Review(String body, long rating, User user) {
        this.body = body;
        this.rating = rating;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
