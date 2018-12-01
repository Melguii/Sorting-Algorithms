import java.util.List;

public class User {
    private String              username;
    private Integer             followers;
    private Integer             follows;
    private List<Connection>    connections;
    private List<Post>          posts;
    private List<Integer>       likedPosts;
    private List<Integer>       commentedPosts;
    private List<User>          link;                   //Informacio dels usuaris dels quals interacciona/segueix

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollows() {
        return follows;
    }

    public void setFollows(Integer follows) {
        this.follows = follows;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Integer> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(List<Integer> likedPosts) {
        this.likedPosts = likedPosts;
    }

    public List<Integer> getCommentedPosts() {
        return commentedPosts;
    }

    public void setCommentedPosts(List<Integer> commentedPosts) {
        this.commentedPosts = commentedPosts;
    }
}
