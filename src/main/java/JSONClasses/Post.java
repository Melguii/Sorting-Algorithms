package JSONClasses;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private int          id;
    private long         published;
    private List<Float>  location;
    private String       category;
    private List<String> liked_by;
    private List<String> commented_by;
    private List<User>   usersLikes;                //Informacio dels users que han donat like (ho sabem gracies linkedBy)
    private List<User>   usersComments;             //Informacio dels users que han comentat (ho sabem gracies commentedBy)
    private long         comparacioUbicacio;        //Distancia entre usuaris

    /**
     * Retorna la diferencia en distancia calculada en Haversine entre la ubicacio de referencia i l'ubicacio del Post
     * @return Distancia en Haversine
     */
    public long getComparacioUbicacio() {
        return comparacioUbicacio;
    }
    /**
     * Estableix la diferencia en distancia calculada en Haversine
     * @return Distancia en Haversine
     */
    public void setComparacioUbicacio(long comparacioUbicacio) {
        this.comparacioUbicacio = comparacioUbicacio;
    }

    /**
     * Constructor de Post, necessari per establir a de quin tipus concret es la interficie List
     */
    public Post() {
        this.location = new ArrayList<Float>();
        this.liked_by = new ArrayList<String>();
        this.commented_by = new ArrayList<String>();
        this.usersLikes = new ArrayList<User>();
        this.usersComments = new ArrayList<User>();
    }

    /**
     * Getter de ID
     * @return Valor actual de ID
     */
    public int getId() {
        return id;
    }

    /**
     * Setter de ID
     * @param id Valor que establim a ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter de Published
     * @return Valor actual de published
     */
    public long getPublished() {
        return published;
    }

    /**
     * Setter de Published
     * @param published Valor que establim a Published
     */
    public void setPublished(long published) {
        this.published = published;
    }

    /**
     * Getter de Location
     * @return Valors actuals que té la l'atribut de tipus llista Location
     */
    public List<Float> getLocation() {
        return location;
    }

    /**
     * Setter de Location
     * @param location Valors que volem assignar a l'atribut tipus llista location
     */
    public void setLocation(List<Float> location) {
        this.location = location;
    }

    /**
     * Getter  de Category
     * @return Valor actual de Category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter de Category
     * @param category Valor que volem establir a l'atribut Category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter de liked_by
     * @return Valor actual de l'atribut llista liked_by
     */
    public List<String> getLiked_by() {
        return liked_by;
    }

    /**
     * Setter de liked_by
     * @param liked_by Valors que volem assignar a l'atribut tipus llista liked_by
     */
    public void setLiked_by(List<String> liked_by) {
        this.liked_by = liked_by;
    }

    /**
     * Getter de commented_by
     * @return Valor actual de l'atribut tipus llista commented_by
     */
    public List<String> getCommented_by() {
        return commented_by;
    }

    /**
     * Setter de commented_by
     * @param commented_by Valors que volem assignar a l'atribut de tipus llista commented_by
     */
    public void setCommented_by(List<String> commented_by) {
        this.commented_by = commented_by;
    }

    /**
     * Getter de usersLikes
     * @return Valor actual de l'atribut tipus llista usersLikes
     */
    public List<User> getUsersLikes() {
        return usersLikes;
    }

    /**
     * Setter de usersLikes
     * @param usersLikes Valor que assignem a l'atribut de tipus llista usersLikes
     */
    public void setUsersLikes(List<User> usersLikes) {
        this.usersLikes = usersLikes;
    }

    /**
     * Getter de usersComments
     * @return Valor actual de l'atribut tipus llista usersComments
     */
    public List<User> getUsersComments() {
        return usersComments;
    }

    /**
     * Setter de usersComments
     * @param usersComments Valor que volem assignar a l'atribut tipus llista usersComments
     */
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

    public void calculHaversine (float longitudRef, float latitudRef) {
        double dlatitud = Math.toRadians(latitudRef-this.location.get(0));
        double dlongitud = Math.toRadians(longitudRef-this.location.get(1));
        comparacioUbicacio = (int) (100000 *(2 * Math.asin(Math.sqrt(Math.pow(Math.sin(dlatitud/2),(float)2)+Math.cos(this.location.get(0))*Math.cos(latitudRef)*Math.pow(Math.sin(dlongitud/2),2)))));
    }
}
