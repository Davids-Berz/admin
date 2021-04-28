package expert;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Home {

    public static void main(String[] args) {

        final String SITE = "Expert";
        final String LISTING = "D:\\David\\tickets\\workit\\cp\\expert\\listing.html";
        final String HOME = "D:\\David\\tickets\\workit\\cp\\expert\\listing.html";
        final String DataInformation = "D:\\David\\tickets\\workit\\cp\\expert\\data.html";
        Path path = Paths.get(DataInformation);
        List<String> html = null;
        try {
            html = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document document = Jsoup.parse(html.toString());

        Elements cross = document.select("[widget-child=item_1_2] .widget-ArticlePPM-ppm-listentry");
        Elements cs = document.select("div[data-count] div[widget-child].referenced");

        System.out.println();
    }
}




