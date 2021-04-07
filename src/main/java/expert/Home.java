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
        Path path = Paths.get(HOME);
        List<String> html = null;
        try {
            html = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document document = Jsoup.parse(html.toString());

        // HOME
        Elements category = document.select(".widget-CategoryList-subCategoryWrapper > li > a[href^=/shop]");
        Elements category2 = document.select(".widget-CategoryList a");

        // Listing breadcrumb
        /*Elements ident = document.select("div.widget.widget-ArticleList");
        Elements br = document.select("ul#bcp>li[itemtype*=Breadcrumb]>a:not(:contains(Unsere Produkte)), ol.widget-Breadcrumb-breadtrunc > li.widget-Breadcrumb-breadCrumb > a:not(:contains(Startseite))");*/


        System.out.println();
    }
}
