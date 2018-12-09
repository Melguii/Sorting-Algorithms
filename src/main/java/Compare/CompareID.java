package Compare;

import JSONClasses.Post;

public class CompareID implements Comparator{
    public boolean compararp1top2 (Post post1, Post post2) {
        boolean b = false;
        if (post1.getId() > post2.getId()) {
            b = true;
        }
        return b;
    }
    public boolean compararp2top1 (Post post1, Post post2) {
        boolean b = false;
        if (post1.getId() < post2.getId()) {
            b = true;
        }
        return b;
    }
    public boolean compararp2top1IncludeEqual (Post post1, Post post2) {
        boolean b = false;
        if (post1.getId() <= post2.getId()) {
            b = true;
        }
        return b;
    }
    public long retornarValor (Post post) {
        return (long) post.getId();
    }
}
