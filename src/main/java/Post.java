import java.util.ArrayList;
import java.util.List;

public class Post {
    private int          id;
    private int          published;
    private List<Double> location;
    private String       category;
    private List<String> likedBy;
    private List<String> commentedBy;
    private List<User>   usersLikes;                //Informacio dels users que han donat like (ho sabem gracies linkedBy)
    private List<User>   usersComments;             //Informacio dels users que han comentat (ho sabem gracies commentedBy)


    public Post() {
        this.location = new ArrayList<Double>();
        this.likedBy = new ArrayList<String>();
        this.commentedBy = new ArrayList<String>();
        this.usersLikes = new ArrayList<User>();
        this.usersComments = new ArrayList<User>();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public List<User> getUsersLikes() {
        return usersLikes;
    }

    public void setUsersLikes(List<User> usersLikes) {
        this.usersLikes = usersLikes;
    }

    public List<User> getUsersComments() {
        return usersComments;
    }

    public void setUsersComments(List<User> usersComments) {
        this.usersComments = usersComments;
    }

    public void referenciarUserLikes (User u[]){
        boolean trobat;
        int i;

        for (String likedBy: this.likedBy) {
            trobat = false;
            i = 0;

            while (trobat == false && i < u.length) {

                if (likedBy.equals(u[i].getUsername())) {
                    usersLikes.add(u[i]);
                    trobat = true;
                }

                i++;
            }
        }
    }
}
