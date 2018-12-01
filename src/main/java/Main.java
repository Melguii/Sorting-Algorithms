import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * Llegim el fitxer Json
         */
        Gson gson = new Gson();
        FileReader f = new FileReader("datasets/xs_dataset.json");
        User[] users = gson.fromJson(f, User[].class);

    }
}
