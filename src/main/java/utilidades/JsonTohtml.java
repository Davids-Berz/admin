package utilidades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonTohtml {

    public static void main(String[] args) {
        final String SITE = "";
        //aqui agregas el path donde guardas el archivo json o txt
        Path path = Paths.get("D:\\David\\tickets\\workit\\cp\\expert\\expert-de.html");
        List<String> str = null;
        try {
            str = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // aqui creas un metodo para limpiar el codigo
        str  = cleanJson(str);

    }

    static List<String> cleanJson(List<String> str){
        //to do
        return str;
    }
}

