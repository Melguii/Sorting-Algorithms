package Sorts;

import Compare.Comparator;
import JSONClasses.Post;


import java.util.ArrayList;
import java.util.List;

public class MergeSortArrayInts {
    /**
     *
     * @param s
     * @param i
     * @param j
     * @return
     */
    public List<Integer> mergeSort (List<Integer> s, int i, int j) {
        int mig;
        if (i >= j) {
            return s;
        }
        else {
            mig = (i + j) / 2;
            s = mergeSort (s,i,mig);
            s = mergeSort (s,mig+1,j);
            s = merge (s,i,mig,j);
        }
        return s;
    }

    /**
     *
     * @param s
     * @param i
     * @param mig
     * @param j
     * @return
     */
    private List<Integer> merge (List<Integer> s,int i, int mig, int j) {
        List<Integer> b = new ArrayList<Integer>();
        int k1;
        int k2;
        int cursor;
        int kr;
        k1 = i;
        k2 = mig + 1;
        cursor = 0;
        while ((k1 <= mig) && (k2 <= j) ) {
            if (s.get(k1) <= s.get(k2)) {
                b.add(s.get(k1));
                k1 = k1 + 1;
                cursor = cursor + 1;
            }
            else {
                b.add(s.get(k2));
                k2 = k2 + 1;
                cursor = cursor + 1;
            }
        }
        while (k1 <= mig) {
            b.add(s.get(k1));
            k1 = k1 + 1;
            cursor = cursor + 1;
        }
        while (k2 <= j) {
            b.add(s.get(k2));
            k2 = k2 + 1;
            cursor = cursor + 1;
        }
        cursor = 0;
        kr = i;
        while (kr <= j) {
            s.set(kr,b.get(cursor));
            kr = kr + 1;
            cursor = cursor + 1;
        }

        return s;
    }
}
