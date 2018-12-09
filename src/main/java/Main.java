import Compare.Comparator;
import Compare.CompareID;
import JSONClasses.Menu;
import JSONClasses.Post;
import JSONClasses.User;
import Sorts.MergeSort;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Llegim el fitxer Json amb array de object perque tenim la informacio al json de una sola classe, no de varies
        Gson gson = new Gson();
        Menu menu_fitxers = new Menu();
        FileReader f = menu_fitxers.menuFitxers();
        if (f != null) {
            User[] users = gson.fromJson(f, User[].class);
            List<Post> p = new ArrayList <Post>();
            //Referenciem els follows de cada usuari i,
            // cada post amb els Usuaris que li fan like i comentaris per separat
            for (int i = 0; i < users.length; i++) {
                users[i].referenciarSeguidors(users);
                for (int j = 0; j < users[i].getPosts().size(); j++) {
                    p.add(users[i].getPosts().get(j));
                }
            }
            Comparator c = new CompareID();
            MergeSort mergesort = new MergeSort ();
            mergesort.mergeSort(p,c,0, p.size()-1);
            for (int i = 0; i < users.length; i++) {
                users[i].referenciarPostAgradats(p);
                users[i].referenciarPostComentats(p);
            }
            Menu m = new Menu();
            m.implementacioMenu(users);
        }
    }
}
