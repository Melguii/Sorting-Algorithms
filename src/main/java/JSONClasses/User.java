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
    private List <Post>         postsAgradats;
    private List <Post>         postsComentats;


    public User() {
        this.connections = new ArrayList<Connection>();
        this.posts = new ArrayList<Post>();
        this.likedPosts = new ArrayList<Integer>();
        this.commentedPosts = new ArrayList<Integer>();
        this.link = new ArrayList<User>();
        this.postsAgradats = new ArrayList <Post>();
        this.postsComentats = new ArrayList <Post>();
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
    public void referenciarPostAgradats (List <Post> p){
        boolean b;
        int j = 0;
        for (int i = 0; i < likedPosts.size(); i++) {
            b = false;
            j = 0;
            while (j < p.size() && b == false) {
                if (p.get(j).getId() == likedPosts.get(i)) {
                    b = true;
                    postsAgradats.add(p.get(j));
                }
                j++;
            }
        }
    }
    public void referenciarPostComentats (List <Post> p){
        boolean b;
        int j = 0;
        for (int i = 0; i < commentedPosts.size(); i++) {
            j = 0;
            b = false;
            while (j < p.size() && b == false) {
                if (p.get(j).getId() == commentedPosts.get(i)) {
                    b = true;
                    postsComentats.add(p.get(j));
                }
                j++;
            }
        }
    }
    //Calcula el percentatge de interes de l'usuari, segons la categoria del Post
    public void interesCategoria (Post post) {

    }


}
