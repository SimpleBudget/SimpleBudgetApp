package club.simplebudget.budgetapp.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment commentId;

    public Comment() {
    }

    public Comment(long id, String comment, long rating, Post post, User user, Comment commentId, List<Comment> comments) {
        this.id = id;
        this.commentbody = comment;
        this.rating = rating;
        this.post = post;
        this.user = user;
        this.commentId = commentId;
        this.comments = comments;
    }

    public Comment(String commentbody, long rating, Post post, User user, List<Comment> comments, Comment commentId) {
        this.commentbody = commentbody;
        this.rating = rating;
        this.post = post;
        this.user = user;
        this.comments = comments;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Comment getCommentId() {
        return commentId;
    }

    public void setCommentId(Comment commentId) {
        this.commentId = commentId;
    }
}
