package JSONClasses;

import JSONClasses.Connection;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String              username;
    private int                 followers;
    private int                 follows;
    private List<Connection>    connections;
    private List<Post>          posts;
    private List<Integer>       likedPosts;
    private List<Integer>       commentedPosts;
    private List<User>          link;                   //Informacio dels usuaris dels quals interacciona/segueix


    public User() {
        this.connections = new ArrayList<Connection>();
        this.posts = new ArrayList<Post>();
        this.likedPosts = new ArrayList<Integer>();
        this.commentedPosts = new ArrayList<Integer>();
        this.link = new ArrayList<User>();
    }

    public List<User> getLink() {
        return link;
    }

    public void setLink(List<User> link) {
        this.link = link;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
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

    /**
     * De l'usuari en concret afegim la informació dels usuaris als quals segeuix/interactua
     * @param u Array que conte la llista de tots els usuaris de la plataforma
     */
    public void referenciarSeguidors (User u[]) {
        boolean trobat;
        int i;

        for (Connection c: connections) {
            trobat = false;
            i = 0;

            while (trobat == false && i < u.length) {

                if (c.getUsername().equals(u[i].getUsername())) {
                    link.add(u[i]);
                    trobat = true;
                }

                i++;
            }
        }
    }


}
