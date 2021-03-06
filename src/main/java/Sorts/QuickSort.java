package Sorts;

import Compare.Comparator;
import JSONClasses.Post;
import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    /**
     *
     * @param p
     * @param c
     * @param i
     * @param j
     * @return
     */
    public List<Post> quickSort (List<Post> p, Comparator c, int i, int j) {
        int s;
        int t;
        int array_aux_ij [] = new int [2];
        int array_aux_st [] = new int [2];

        if (i >= j) {
            return p;
        }
        else{
            array_aux_ij[0] = i;
            array_aux_ij[1] = j;
            array_aux_st = particio(p,array_aux_ij,c);
            s = array_aux_st[0];
            t = array_aux_st[1];
            p = quickSort(p,c,i,t);
            p = quickSort(p,c,s,j);
        }
        return p;
    }

    /**
     *
     * @param p
     * @param array_aux_ij
     * @param c
     * @return
     */
    private int [] particio (List <Post> p, int array_aux_ij[], Comparator c) {
        int mig;
        Post pivot;
        Post tmp = new Post();
        int s;
        int t;
        s = array_aux_ij[0];
        t = array_aux_ij[1];
        mig = (array_aux_ij[0] + array_aux_ij[1])/2;
        pivot = p.get(mig);
        while (s <= t) {
            while (c.compararp2top1(p.get(s),pivot)) {
                s = s + 1;
            }
            while (c.compararp1top2(p.get(t),pivot)) {
                t = t - 1;
            }
            if (s < t) {
                tmp = p.get(s);
                p.set(s, p.get(t));
                p.set(t,tmp);
                s = s + 1;
                t = t - 1;
            }
            else {
                if (s == t) {
                    s = s + 1;
                    t = t - 1;
                }
            }
        }
        int [] array_aux_st = new int[2];
        array_aux_st[0]= s;
        array_aux_st[1]=t;

        return array_aux_st;
    }
}
