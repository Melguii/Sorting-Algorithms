import java.util.ArrayList;
import java.util.List;

public class Post {
    private int          id;
    private int          published;
    private List<Double> location;
    private String       category;
    private List<String> liked_by;
    private List<String> commented_by;
    private List<User>   usersLikes;                //Informacio dels users que han donat like (ho sabem gracies linkedBy)
    private List<User>   usersComments;             //Informacio dels users que han comentat (ho sabem gracies commentedBy)

    /**
     * Constructor de Post, necessari per establir a de quin tipus concret es la interficie List
     */
    public Post() {
        this.location = new ArrayList<Double>();
        this.liked_by = new ArrayList<String>();
        this.commented_by = new ArrayList<String>();
        this.usersLikes = new ArrayList<User>();
        this.usersComments = new ArrayList<User>();
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

    public List<String> getLiked_by() {
        return liked_by;
    }

    public void setLiked_by(List<String> liked_by) {
        this.liked_by = liked_by;
    }

    public List<String> getCommented_by() {
        return commented_by;
    }

    public void setCommented_by(List<String> commented_by) {
        this.commented_by = commented_by;
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

    /**
     * Funcio que ens permet referenciar els usuaris que han donat Like a un post concret
     * @param u Indica tots els usuaris de la plataforma, cosa que ens serveix per poder buscar-los per fer la
     *          'traduccio' de String a User
     */
    public void referenciarUserLikes (User u[]){
        boolean trobat;
        int i;
        for (String like:this.liked_by) {
            trobat = false;
            i = 0;
            while (trobat == false && i < u.length) {

                if (like.equals(u[i].getUsername())) {
                    usersLikes.add(u[i]);
                    trobat = true;
                }

                i++;
            }
        }
    }

    /**
     * Funcio que ens permet referenciar els usuaris que han comentat un post concret
     * @param u Indica tots els usuaris de la plataforma, cosa que ens serveix per poder buscar-los per fer
     *          la 'traduccio' de String a User
     */
    public void referenciarUserComments (User u[]){
        boolean trobat;
        int i;
        for (String comment:this.commented_by) {
            trobat = false;
            i = 0;
            while (trobat == false && i < u.length) {

                if (comment.equals(u[i].getUsername())) {
                    usersComments.add(u[i]);
                    trobat = true;
                }

                i++;
            }
        }
    }
}
