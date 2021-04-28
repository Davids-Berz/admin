package utilidades;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonTohtml {

    public static void main(String[] args) {
        final String SITE = "";
        //aqui agregas el path donde guardas el archivo json o txt
        Path path = Paths.get("C:/Users/Wiser/Documents/ajax/ajax-json.json");

        List<String> str = null;
        try {
            str = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // aqui creas un metodo para limpiar el codigo
        String cleanStr  = cleanJson(str);

        Document document = Jsoup.parse(cleanStr, "", Parser.htmlParser());
        System.out.println();

        String a = document.select("a").text();
        System.out.println(a);

    }

    static String cleanJson(List<String> str){
        //to do
         String body = StringUtils.substringBetween(str.toString(), "\"modules\":\"","\",\"total\"");
         body = StringUtils.replaceAll(body,"\\n", "");
         return body.toString() ;
    }
}

