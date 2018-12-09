package JSONClasses;

import Compare.*;
import EstructuresDades.TaulaHash;
import JSONClasses.Connection;
import Sorts.MergeSort;
import Sorts.MergeSortArrayInts;
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

    /**
     * Getter de Link
     * @return Informacio complerta actual de tots els usuaris que segueixen a un usuari en concret
     */
    public List<User> getLink() {
        return link;
    }

    /**
     * Setter de Link
     * @param link Es l'array de l'users que assignarem a el nostre array link
     */
    public void setLink(List<User> link) {
        this.link = link;
    }

    /**
     * Get de Username
     * @return El nom actual d'un usuari en concret
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter de Username
     * @param username Nom d'usuari que assignem a un usuari en concret
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter de Followers
     * @return Numero de followers que te actualment un usuari en concret
     */
    public int getFollowers() {
        return followers;
    }

    /**
     * Setter de Followers
     * @param followers Valor que volem assignar a els followers d'un usuari
     */
    public void setFollowers(int followers) {
        this.followers = followers;
    }

    /**
     * Getter de Follows
     * @return Numero de seguits actual de l'usuari
     */
    public int getFollows() {
        return follows;
    }

    /**
     * Setter de Follows
     * @param follows Numero de seguits que volem assignar a un usuari en concret
     */
    public void setFollows(int follows) {
        this.follows = follows;
    }

    /**
     * Getter de connections
     * @return Array de connections actual de l'usuari (conte tota la informacio de els usuaris amb qui l'usuari desitjat interacciona)
     */
    public List<Connection> getConnections() {
        return connections;
    }

    /**
     * Setter de connections
     * @param connections Array de connections (que conte tota la informacio de les interaccions de l'usuari) que assignem a un usuari concret
     */
    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    /**
     * Getter de posts
     * @return Retornem l'array amb tota la informació dels posts que té l'usuari actualment
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Setter de posts
     * @param posts Array de posts que volem assignar a un usuari en concret
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * Getter de likedPosts
     * @return Tots els Id dels posts que ha donat like l'usuari
     */
    public List<Integer> getLikedPosts() {
        return likedPosts;
    }

    /**
     * Setter de likedPosts
     * @param likedPosts Array de ints (ple de ids de posts) que volem assignar a un usuari en concret
     */
    public void setLikedPosts(List<Integer> likedPosts) {
        this.likedPosts = likedPosts;
    }

    /**
     * Getter de CommentedPosts
     * @return Tots els Id dels posts que ha comentat l'usuari
     */
    public List<Integer> getCommentedPosts() {
        return commentedPosts;
    }

    /**
     *
     * @param commentedPosts
     */
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

    public void referenciarPostAgradats (List <Post> p) {
        int valor;
        for (int i = 0; i < likedPosts.size(); i++) {
           valor = busquedaBinaria(likedPosts.get(i), p);
           postsAgradats.add (p.get(valor));
        }
    }
    /*public void referenciarPostAgradats (List <Post> p){
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
    }*/

    /**
     *
     * @param p
     */
    public void referenciarPostComentats (List <Post> p){
        //boolean b;
        //int j = 0;
        int valor;
        for (int i = 0; i < commentedPosts.size(); i++) {
            valor = busquedaBinaria(commentedPosts.get(i), p);
            postsComentats.add (p.get(valor));
        }
        /*for (int i = 0; i < commentedPosts.size(); i++) {
            j = 0;
            b = false;
            while (j < p.size() && b == false) {
                if (p.get(j).getId() == commentedPosts.get(i)) {
                    b = true;
                    postsComentats.add(p.get(j));
                }
                j++;
            }
        }*/
    }

    private int busquedaBinaria( int valorBuscat, List <Post> p) {
        int principi = 0;
        int fin = p.size() - 1;
        int valor_resultat = 0;
        int mig = (principi + fin)/2;
        boolean b = false;
        while (!b && (principi <= fin)){
            mig = (principi + fin)/2;
            if (p.get(mig).getId() == valorBuscat) {
                b = true;
                valor_resultat = mig;
            }
            else {
                if (p.get(principi).getId() == valorBuscat) {
                    b = true;
                    valor_resultat = principi;
                }
                else {
                    if (p.get(fin).getId() == valor_resultat) {
                        b = true;
                        valor_resultat = fin;
                    }
                    else {
                        if (p.get(mig).getId() > valorBuscat) {
                            fin = mig - 1;
                        } else {
                            principi = mig + 1;
                        }
                    }
                }
            }
        }
        return valor_resultat;
    }
    /**
     *
     * @param p
     * @return
     */
    //Calcula el percentatge de interes de l'usuari, segons la categoria del Post(basat en likes)
    private List <Float> interesCategoria (List <String> p) {
        List <Integer> numeroInteraccions = new ArrayList <Integer>();
        List <Float> percentatgesCategories = new ArrayList<Float>();
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
            percentatge = ((float)numeroInteraccions.get(w)/(likedPosts.size() + commentedPosts.size() + posts.size()));
            percentatgesCategories.add(percentatge);
        }
        return percentatgesCategories;
    }

    /**
     *
     * @param s
     * @param sRef
     * @param numeroLikesCat
     * @param j
     */
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

    /**
     *
     * @param nomsUsuaris
     * @return
     */
    private List <Float> interesUsuari (List<String> nomsUsuaris) {
        List <Float> valorInteres = new ArrayList<Float>();
        int valorVisites;
        int valorLikes;
        int valorComments;
        float valorTotal;
        for (int i = 0; i < connections.size(); i++) {
            valorVisites = calculValorVisits (connections.get(i).getVisits());
            valorLikes = connections.get(i).getLikes();
            valorComments = connections.get(i).getComments();
            valorTotal = valorVisites + valorLikes + valorComments;
            nomsUsuaris.add(connections.get(i).getUsername());
            valorInteres.add(valorTotal);

        }
        return valorInteres;
    }

    /**
     *
     * @param visites
     * @return
     */
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

    /**
     *
     * @param postsUsuari
     * @param propietarisPost
     * @return
     */
    private List <Float> calculTemporalitat (List <Post> postsUsuari, List <String> propietarisPost) {
        List <Float> valorsTemps = new ArrayList <Float>();
        long maximTemps;
        for (int i = 0; i < link.size(); i++) {
            for (int j=0; j < link.get(i).getPosts().size();j++) {
                postsUsuari.add(link.get(i).getPosts().get(j));
                propietarisPost.add(link.get(i).username);
            }
        }
        maximTemps = buscarMaxim (postsUsuari,0,0);
        valorsTemps = calculValorTemps(postsUsuari, maximTemps);
        return valorsTemps;
    }

    /**
     *
     * @param postsUsuari
     * @param i
     * @param max
     * @return
     */
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

    /**
     *
     * @param postsUsuari
     * @param maximTemps
     * @return
     */
    private List <Float> calculValorTemps (List <Post> postsUsuari, long maximTemps) {
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
        }
        return valorsTemps;
    }

    /**
     *
     * @param tempsAct
     * @param maxim
     * @param c
     * @return
     */
    private float assignarValor (long tempsAct, long maxim, CompareTimeStamps c) {
        float valor;
        //0h a 6h
        if (c.compareTimestamps(tempsAct,maxim,3600)) {
            valor = 1;
        }
        else{
            if (c.compareTimestamps(tempsAct, maxim, 10800)) {
                valor = 0.9f;
            }
            else {
                if (c.compareTimestamps(tempsAct, maxim, 21600)) {
                    valor = 0.8f;
                } else {
                    if (c.compareTimestamps(tempsAct, maxim, 43200)) {
                        valor = 0.70f;
                    } else {
                        if (c.compareTimestamps(tempsAct, maxim, 86400)) {
                            valor = 0.60f;
                        } else {
                            if (c.compareTimestamps(tempsAct, maxim, 259200)) {
                                valor = 0.50f;
                            } else {
                                if (c.compareTimestamps(tempsAct, maxim, 604800)) {
                                    valor = 0.40f;
                                } else {
                                    if (c.compareTimestamps(tempsAct, maxim, 1209600)) {
                                        valor = 0.3f;
                                    } else {
                                        if (c.compareTimestamps(tempsAct, maxim, 2419200)) {
                                            valor = 0.25f;
                                        } else {
                                            //Entre 4 i 8 semanes
                                            if (c.compareTimestamps(tempsAct, maxim, 4838400)) {
                                                valor = 0.2f;
                                            } else {
                                                if (c.compareTimestamps(tempsAct, maxim, 14515200)) {
                                                    valor = 0.1f;
                                                } else {
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
            }
        }
        return valor;
    }

    /**
     *
     */
    public void calculPrioritats () {
        List <Float> interesUsuaris;
        List <String> usernamesFollows = new ArrayList<String>();
        List <Post> postsFollows = new ArrayList<Post>();
        List <Float> valorTemporalitat;
        List <Float> percentatgeCategories;
        List <String> nomsCategories = new ArrayList<String>();
        List <String> hashNomsUsuaris = new ArrayList<String>();
        List <String> hashNomsCategories = new ArrayList<String>();
        List <String> propietarisPosts = new ArrayList<String>();

        interesUsuaris = interesUsuari (usernamesFollows); //Com obtenim els arrays resultatnts;
        valorTemporalitat = calculTemporalitat (postsFollows, propietarisPosts);
        percentatgeCategories = interesCategoria (nomsCategories);

        float [] hashCategories;
        float [] hashInteresUsuaris;

        TaulaHash h = new TaulaHash();
        hashCategories = h.indexarHash(nomsCategories, percentatgeCategories,hashNomsCategories);
        hashInteresUsuaris = h.indexarHash(usernamesFollows,interesUsuaris,hashNomsUsuaris);
        float percentatgeCat;
        float interesEnUsuari;
        float valorTemp;
        long valorPrioritat;
        for (int w = 0; w < postsFollows.size();w++) {
            int index;
            index = h.hash(postsFollows.get(w).getCategory(),hashNomsCategories);
            if (index >= 0) {
                percentatgeCat = hashCategories[index];
            }
            else {
                percentatgeCat = 0;
            }
            index = h.hash(propietarisPosts.get(w),hashNomsUsuaris);
            if (index >= 0) {
                interesEnUsuari = hashInteresUsuaris [index];
            }
            else {
                interesEnUsuari = 1f;
            }
            valorTemp = valorTemporalitat.get(w);
            valorPrioritat = (long) (1000*(Math.pow(interesEnUsuari * 10 * ((Math.pow(10,percentatgeCat))/10), (valorTemp))));
            postsFollows.get(w).setValorPrioritat(valorPrioritat);
        }
        Comparator c = new ComparePrioritats();
        QuickSort q = new QuickSort();
        q.quickSort(postsFollows,c,0,postsFollows.size()-1);
        for (int i= (postsFollows.size() - 1); i >= 0;i--) {
            System.out.println(postsFollows.get(i).getId() + "  " + postsFollows.get(i).getCategory() + " " + postsFollows.get(i).getValorPrioritat());
        }
    }
}
