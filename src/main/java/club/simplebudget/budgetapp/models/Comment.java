package club.simplebudget.budgetapp.models;
import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String comment;
    @Column
    private long rating;
    @OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private Post post;
    @OneToOne
    private User user;
    @OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private Comment commentId;

    public Comment() {
    }

    public Comment(long id, String comment, long rating, Post post, User user, Comment commentId) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
        this.post = post;
        this.user = user;
        this.commentId = commentId;
    }

    public Comment(String comment, long rating, Post post, User user, Comment commentId) {
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
