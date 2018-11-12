package club.simplebudget.budgetapp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false)
    private String body;
    @OneToOne
    private User user;
    @ManyToMany
    @JoinTable(name = "post_comments", joinColumns={@JoinColumn(name="post_id")}, inverseJoinColumns = {@JoinColumn(name="comment_id")})
    private List<Comment> comments;
    public Post(){
    }

    public Post(long id, String title, String body, User user, ArrayList<Comment> comments) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.comments = comments;
    }

    public Post(String title, String body, User user, ArrayList<Comment> comments) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
    public void addComment(Comment comment){
        comments.add(comment);
    }
}
