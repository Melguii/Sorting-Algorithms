package Compare;

import JSONClasses.Post;

public interface Comparator {
    public boolean compararp1top2 (Post post1, Post post2);
    public boolean compararp2top1 (Post post1, Post post2);
    public boolean compararp2top1IncludeEqual (Post post1, Post post2);
    public boolean compararDigits(Post post1, Post post2);
    public float retornarValor (Post post);
}
