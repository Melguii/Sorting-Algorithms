package Compare;

import JSONClasses.Post;

public class CompareUbicacio implements Comparator{
    /**
     * Veiem si la primera publicacio esta més lluny de la de referencia que la segona
     * @param post1 Primer post que volem comparar
     * @param post2 Segon post que volem comparar
     * @return Si p1.distanciatoReference > p2.distanciatoReference
     */
    public boolean compararp1top2 (Post post1, Post post2) {
        boolean b = false;
        long resultat1 = post1.getComparacioUbicacio();
        long resultat2 = post2.getComparacioUbicacio();
        if (resultat1 > resultat2) {
            b = true;
        }
        return b;
    }

    /**
     * Veiem si la segona publicacio esta més lluny de la de referencia que la primera
     * @param post1 Primer post que volem comparar
     * @param post2 Segon post que volem comparar
     * @return Si p1.distanciatoReference < p2.distanciatoReference
     */
    public boolean compararp2top1 (Post post1, Post post2) {
        long resultat1 = post1.getComparacioUbicacio();
        long resultat2 = post2.getComparacioUbicacio();
        boolean b = false;
        if (resultat1 < resultat2) {
            b = true;
        }
        return b;
    }

    /**
     * Veiem si la segona publicacio esta més llunt o igual de la de referencia que la primera
     * @param post1 Primer post que volem comparar
     * @param post2 Segon post que volem comparar
     * @return Si p1.distanciatoReference <= p2.distanciatoReference
     */
    public boolean compararp2top1IncludeEqual (Post post1, Post post2) {
        long resultat1 = post1.getComparacioUbicacio();
        long resultat2 = post2.getComparacioUbicacio();
        boolean b = false;
        if (resultat1 <= resultat2) {
            b = true;
        }
        return b;
    }

    /**
     *
     * @param post
     * @return
     */
    public long retornarValor (Post post) {
        return post.getComparacioUbicacio();
    }
}
