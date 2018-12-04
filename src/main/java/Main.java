import JSONClasses.Menu;
import JSONClasses.User;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //Llegim el fitxer Json amb array de object perque tenim la informacio al json de una sola classe, no de varies
        Gson gson = new Gson();
        FileReader f = new FileReader("datasets/xs_dataset.json");
        User[] users = gson.fromJson(f, User[].class);

        //Referenciem els follows de cada usuari i,
        // cada post amb els Usuaris que li fan like i comentaris per separat
        for (int i = 0; i < users.length; i++) {
            users[i].referenciarSeguidors(users);
            for (int j = 0; j < users[i].getPosts().size(); j++){
                users[i].getPosts().get(j).referenciarUserLikes(users);
                users[i].getPosts().get(j).referenciarUserComments(users);
            }
        }
        Menu m = new Menu();
        m.implementacioMenu(users);
    }
}
