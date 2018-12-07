package JSONClasses;

import Compare.*;
import JSONClasses.Connection;
import Sorts.QuickSort;

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

    /**
     * Constructor per a User, això el que ens permet establir que les List especificades seran ArrayList
     */
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
    //Calcula el percentatge de interes de l'usuari, segons la categoria del Post(basat en likes)
    private void interesCategoria () {
        List<String> p = new ArrayList <String>();
        List <Integer> numeroInteraccions = new ArrayList <Integer>();
        float percentatge;
        for (int i = 0; i < postsAgradats.size(); i++) {
           trobarPost (postsAgradats.get(i).getCategory(),p,numeroInteraccions,0);
        }
        for (int i = 0; i < postsComentats.size();i++) {
            trobarPost (postsComentats.get(i).getCategory(),p,numeroInteraccions,0);
        }
        for (int i = 0; i < posts.size();i++) {
            trobarPost (posts.get(i).getCategory(),p,numeroInteraccions,0);
        }
        for (int w=0 ; w < p.size();w++){
            percentatge = ((float)numeroInteraccions.get(w)/(likedPosts.size() + commentedPosts.size() + posts.size())) * 100;
            System.out.println(p.get(w) + "-" + percentatge);
        }
    }
    private void trobarPost (String s,List <String> sRef,List <Integer> numeroLikesCat,int j) {
        if (sRef.size() == 0 || s.equals(sRef.get(j)) || (j == (sRef.size()-1))) {
            if (sRef.size() != 0 && s.equals(sRef.get(j))) {
                numeroLikesCat.set(j, numeroLikesCat.get(j) + 1);
            }
            else {
                sRef.add(s);
                numeroLikesCat.add(1);
            }
        }
        else {
            trobarPost(s,sRef,numeroLikesCat,j+1);
        }
    }
    private void interesUsuari () {
        List <Integer> valorInteres = new ArrayList<Integer>();
        int valorvisites;
        int valorlikes;
        int valorcomments;
        int valortotal;
        for (int i = 0; i < connections.size(); i++) {
            valorvisites = calculValorVisits (connections.get(i).getVisits());
            valorlikes = connections.get(i).getLikes();
            valorcomments = connections.get(i).getComments();
            valortotal = valorvisites + valorlikes + valorcomments;
            System.out.println(connections.get(i).getUsername() + " - " + valortotal);
        }
    }
    private int calculValorVisits (int visites) {
        int valor;
        if (visites < 8) {
            valor = 1;
        }
        else {
            if (visites < 20) {
                valor = 5;
            }
            else {
                if (visites < 35) {
                    valor = 10;
                }
                else {
                    if (visites < 50) {
                        valor = 20;
                    }
                    else {
                        if (visites < 75) {
                            valor = 30;
                        }
                        else {
                            if (visites < 150) {
                                valor = 50;
                            }
                            else {
                                valor = 60;
                            }
                        }
                    }
                }
            }
        }
        return valor;
    }
    private void calculTemporalitat () {
        List <Post> postsUsuari = new ArrayList <Post>();
        long maximTemps;
        for (int i = 0; i < link.size(); i++) {
            for (int j=0; j < link.get(i).getPosts().size();j++) {
                postsUsuari.add(link.get(i).getPosts().get(j));
            }
        }
        maximTemps = buscarMaxim (postsUsuari,0,0);
        calculValorTemps(postsUsuari, maximTemps);
    }
    private long buscarMaxim (List <Post> postsUsuari,int i, long max) {
        if (i == postsUsuari.size()) {
            return max;
        }
        else {
            if (postsUsuari.get(i).getPublished() > max) {
                max = postsUsuari.get(i).getPublished();
            }
            max = buscarMaxim(postsUsuari,i + 1, max);
            return max;
        }
    }
    private void calculValorTemps (List <Post> postsUsuari, long maximTemps) {
        List <Float> valorsTemps = new ArrayList<Float>();
        CompareTimeStamps c;
        if ((postsUsuari.get(0).getPublished() - 10000000000l) > 0) {
            c = new CompareMiliseconds();
        }
        else {
            c = new CompareSeconds();
        }
        for (Post p : postsUsuari) {
            valorsTemps.add(assignarValor(p.getPublished(), maximTemps,c));
            if (assignarValor(p.getPublished(), maximTemps,c) > 0.8) {
                System.out.println(assignarValor(p.getPublished(), maximTemps, c));
            }
        }
    }
    private float assignarValor (long tempsAct, long maxim, CompareTimeStamps c) {
        float valor;
        //0h a 6h
        if (c.compareTimestamps(tempsAct,maxim,21600)) {
            valor = 1;
        }
        else{
            if (c.compareTimestamps(tempsAct,maxim,43200)) {
                valor = 0.95f;
            }
            else {
                if (c.compareTimestamps(tempsAct,maxim,86400)) {
                    valor = 0.9f;
                }
                else {
                    if (c.compareTimestamps(tempsAct,maxim,259200)) {
                        valor = 0.8f;
                    }
                    else {
                        if (c.compareTimestamps(tempsAct,maxim,604800)) {
                            valor = 0.7f;
                        }
                        else {
                            if (c.compareTimestamps(tempsAct,maxim,1209600)) {
                                valor = 0.5f;
                            }
                            else {
                                if (c.compareTimestamps(tempsAct,maxim,2419200)) {
                                    valor = 0.3f;
                                }
                                else {
                                    //Entre 4 i 8 semanes
                                    if (c.compareTimestamps(tempsAct,maxim,4838400)) {
                                        valor = 0.2f;
                                    }
                                    else {
                                        if (c.compareTimestamps(tempsAct,maxim,14515200)) {
                                            valor = 0.1f;
                                        }
                                        else {
                                            valor = 0.05f;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return valor;
    }
    private void indexarUsuaris(List <User> users, List<Integer> interesUsuaris) {
        for (User u:users) {

        }
    }
    private void calculPrioritats () {
        interesUsuari (); //Com obtenim els arrays resultatnts;
        calculTemporalitat ();
        interesCategoria ();
        indexarUsuaris (link, interesUsuaris);
    }
}
