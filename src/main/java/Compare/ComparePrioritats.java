package Compare;

import JSONClasses.Post;

public class ComparePrioritats implements Comparator {

     /** El que fa aquest metode es veure si la primera publicacio te mes prioritat que la segona
     * @param post1 Primer post que volem comparar
     * @param post2 Segon post que volem comparar
     * @return El resultat de la comparacio post1.prioritat > post2.prioritat
     */
    public boolean compararp1top2(Post post1, Post post2) {
        boolean b = false;
        if (post1.getValorPrioritat() > post2.getValorPrioritat()) {
            b = true;
        }
        return b;
    }

    /**
     * El que fa aquest metode es veure si la segona publicacio te mes prioritat que la primera
     * @param post1 Primer post que volem comparar
     * @param post2 Segon post que volem comparar
     * @return El resultat de la comparacio post2.prioritat > post1.prioritat
     */
    public boolean compararp2top1(Post post1, Post post2) {
        boolean b = false;
        if (post1.getValorPrioritat() < post2.getValorPrioritat()) {
            b = true;
        }
        return b;
    }

    /**
     * El que fa aquest metode es veure si la segona publicacio te mes prioritat o igual que la primera
     * @param post1 Primer post que volem comparar
     * @param post2 Segon post que volem comparar
     * @return El resultat de la comparacio post2.prioritat => post1.prioritat
     */
    public boolean compararp2top1IncludeEqual(Post post1, Post post2) {
        boolean b = false;
        if (post1.getValorPrioritat() <= post2.getValorPrioritat()) {
            b = true;
        }
        return b;
    }

    public long retornarValor (Post post) {
        return post.getValorPrioritat();
    }
}
