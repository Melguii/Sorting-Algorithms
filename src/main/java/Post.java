import java.util.ArrayList;
import java.util.List;

public class Post {
    private int          id;
    private int          published;
    private List<Double> location;
    private String       category;
    private List<String> likedBy;
    private List<String> commentedBy;
    private List<User>   like;                //Informacio dels users que han donat like (ho sabem gracies linkedBy)
    private List<User>   comment;             //Informacio dels users que han comentat (ho sabem gracies commentedBy)


    public Post(List<Double> location, List<String> likedBy, List<String> commentedBy, List<User> like, List<User> comment) {
        this.location = new ArrayList<Double>();
        this.likedBy = new ArrayList<String>();
        this.commentedBy = new ArrayList<String>();
        this.like = new ArrayList<User>();
        this.comment = new ArrayList<User>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublished() {
        return published;
    }

    public void setPublished(Integer published) {
        this.published = published;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(List<String> likedBy) {
        this.likedBy = likedBy;
    }

    public List<String> getCommentedBy() {
        return commentedBy;
    }

    public void setCommentedBy(List<String> commentedBy) {
        this.commentedBy = commentedBy;
    }

    public List<User> getLike() {
        return like;
    }

    public void setLike(List<User> like) {
        this.like = like;
    }

    public List<User> getComment() {
        return comment;
    }

    public void setComment(List<User> comment) {
        this.comment = comment;
    }
}
