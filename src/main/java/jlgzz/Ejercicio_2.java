package jlgzz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Ejercicio_2 {

    public static void main(String[] args) {

        String breadcrumb_Selector = ".breadcrumb a:not(:contains(inicio))";
        String offerSize_Selector = ".product-list table   tbody   tr .name a";
        String offerlink_Selector_ATTR = "href";

        String sku_Selector = "[data-description=sku]";
        String sku_Selector_ATTR = "data-sku";

        Document documento = null;
        try {
            documento = Jsoup.connect("https://pcel.com/hardware/procesadores").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements breadcrumb = documento.select(breadcrumb_Selector);

        for(Element category: breadcrumb){
            String categoryTitle = category.text();
            String categoryUrl = category.attr(offerlink_Selector_ATTR);
            System.out.println("title: " + categoryTitle + " url: " + categoryUrl);
        }

        Elements offerSize = documento.select(offerSize_Selector);
        System.out.println("Offer Size = "+ offerSize.size());

        for(Element offerURL: offerSize){

        String title = offerURL.text();
        String URL = offerURL.attr("href");
        System.out.println("title: "+ title +  "\nOffer URL = "+ URL);

//        3.- sku dentro de oferta
//            String sku = documento.select(sku_Selector).attr(sku_Selector_ATTR);
        }
    }
}
