package Sorts;

import Compare.Comparator;
import JSONClasses.Post;

import java.util.ArrayList;

public class MergeSort {
    public ArrayList <Post> mergeSort (ArrayList<Post> p, Comparator c, int i, int j) {
        int mig;
        if (i >= j) {
            return p;
        }
        else {
            mig = (i + j) / 2;
            p = mergeSort (p,c,i,mig);
            p = mergeSort (p,c,mig+1,j);
            p = merge (p,i,mig,j,c);
        }
        return p;
    }
    public ArrayList<Post> merge (ArrayList<Post> p ,int i, int mig, int j, Comparator c) {
        ArrayList<Post> b = new ArrayList<Post> ();
        int k1;
        int k2;
        int cursor;
        int kr;
        k1 = i;
        k2 = mig;
        cursor = 0;
        while ((k1 < mig) && (k2 < j) ) {
            if (c.comparar(p.get(k1), p.get(k2))) {
                b.set(cursor,p.get(k1));
                k1 = k1 + 1;
                cursor = cursor + 1;
            }
            else {
                b.set(cursor, p.get(k2));
                k2 = k2 + 1;
                cursor = cursor + 1;
            }
        }
        while (k1 < mig) {
            b.set(cursor,p.get(k1));
            k1 = k1 + 1;
            cursor = cursor + 1;
        }
        while (k2 < j) {
            b.set(cursor, p.get(k2));
            k2 = k2 + 1;
            cursor = cursor + 1;
        }
        cursor = 0;
        kr = i;
        while (kr < j) {
            p.set(kr,b.get(cursor));
            kr = kr + 1;
            cursor = cursor + 1;
        }

        return p;
    }
}
