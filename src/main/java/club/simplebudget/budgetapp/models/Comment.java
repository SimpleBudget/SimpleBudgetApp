package club.simplebudget.budgetapp.models;
import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String commentbody;
    @Column
    private long rating;
    @ManyToOne(cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private Comment commentId;

    public Comment() {
    }

    public Comment(long id, String comment, long rating, Post post, User user, Comment commentId) {
        this.id = id;
        this.commentbody = comment;
        this.rating = rating;
        this.post = post;
        this.user = user;
        this.commentId = commentId;
    }

    public Comment(String comment, long rating, Post post, User user, Comment commentId) {
        this.commentbody = comment;
        this.rating = rating;
        this.post = post;
        this.user = user;
        this.commentId = commentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommentbody() {
        return commentbody;
    }

    public void setCommentbody(String commentbody) {
        this.commentbody = commentbody;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getCommentId() {
        return commentId;
    }

    public void setCommentId(Comment commentId) {
        this.commentId = commentId;
    }
}
