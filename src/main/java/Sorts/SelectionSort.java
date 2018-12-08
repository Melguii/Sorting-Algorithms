package Sorts;

import Compare.Comparator;
import JSONClasses.Post;
import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    /**
     *
     * @param p
     * @param c
     * @return
     */
    public List<Post> selectionSort(List<Post> p, Comparator c) {
        int smallNum;
        Post tmp;

        for (int i = 0; i < (p.size()-1); i++){
            smallNum = i;

            for (int j = i + 1; j < p.size(); j++){
                if (c.compararp2top1(p.get(j),p.get(smallNum))){
                    smallNum = j;
                }
            }

            tmp = p.get(smallNum);
            p.set(smallNum, p.get(i));
            p.set(i,tmp);

        }

        return p;
    }
}
