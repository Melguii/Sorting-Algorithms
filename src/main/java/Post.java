import java.util.List;

public class Post {
    private Integer      id;
    private Integer      published;
    private List<Double> location;
    private String       category;
    private List<String> likedBy;
    private List<String> commentedBy;
    private List<User>   like;                //Informacio dels users que han donat like (ho sabem gracies linkedBy)
    private List<User>   comment;             //Informacio dels users que han comentat (ho sabem gracies commentedBy)


}
