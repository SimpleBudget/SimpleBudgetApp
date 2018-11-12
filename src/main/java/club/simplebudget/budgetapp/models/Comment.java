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
    @ManyToMany(mappedBy = "comments")
    private List<Post> posts;
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private Comment commentId;

    public Comment() {
    }

    public Comment(long id, String comment, long rating, ArrayList<Post> posts, User user, Comment commentId) {
        this.id = id;
        this.commentbody = comment;
        this.rating = rating;
        this.posts = posts;
        this.user = user;
        this.commentId = commentId;
    }

    public Comment(String commentbody, long rating, ArrayList<Post> posts, User user, Comment commentId) {
        this.commentbody = commentbody;
        this.rating = rating;
        this.posts = posts;
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    public void addPost(Post post){
        posts.add(post);
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
