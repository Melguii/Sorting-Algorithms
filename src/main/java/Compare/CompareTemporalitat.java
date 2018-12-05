package Compare;

import JSONClasses.Post;
//import javafx.geometry.Pos;


public class CompareTemporalitat implements Comparator {
    /**
     * El que fa aquest metode es veure si la primera publicacio es va publicar despres que la segona
     * @param post1 Primer post que volem comparar
     * @param post2 Segon post que volem comparar
     * @return El resultat de la comparacio post1.temps > post2.temps
     */
    public boolean compararp1top2(Post post1, Post post2) {
        boolean b = false;
        if (post1.getPublished() > post2.getPublished()) {
            b = true;
        }
        return b;
    }

    /**
     * El que fa aquest metode es veure si la segona publicacio es va publicar despres que la primera
     * @param post1 Primer post que volem comparar
     * @param post2 Segon post que volem comparar
     * @return El resultat de la comparacio post2.temps > post1.temps
     */
    public boolean compararp2top1(Post post1, Post post2) {
        boolean b = false;
        if (post1.getPublished() < post2.getPublished()) {
            b = true;
        }
        return b;
    }

    /**
     * El que fa aquest metode es veure si la segona publicacio es va publicar despres o igual que la primera
     * @param post1 Primer post que volem comparar
     * @param post2 Segon post que volem comparar
     * @return El resultat de la comparacio post2.temps => post1.temps
     */
    public boolean compararp2top1IncludeEqual(Post post1, Post post2) {
        boolean b = false;
        if (post1.getPublished() <= post2.getPublished()) {
            b = true;
        }
        return b;
    }

    public float retornarValor (Post post) {
        return post.getPublished();
    }
}
