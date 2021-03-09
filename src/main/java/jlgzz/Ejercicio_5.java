package jlgzz;

import org.apache.commons.lang3.RegExUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Ejercicio_5 {
    public static void main(String[] args) {

        String target = "https://www.petlove.com.br/mini-adulto-cao-adulto-pequeno-porte-royal-canin/p?sku=3105614-1";

        Document document = null;
        try {
            document = Jsoup.connect(target).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String ratingTotal_Selector = document.select(".label, text-sm").text();
        ratingTotal_Selector = RegExUtils.replaceAll(ratingTotal_Selector, "\\D", "");
        String ratingAverage_Selector = document.select(".row > .col-4.col-sm-3.text-center > .rating-avg").text();

        System.out.println("ratingTotal_Selector = " + ratingTotal_Selector);
        System.out.println("ratingAverage_Selector = " + ratingAverage_Selector);

        Elements reviews = document.select(".user-review");
        int count = 0;

        for(Element review : reviews){
            count++;
            System.out.println(":: review ::" + count);
            String reviewTitle_Selector = review.select(".title").text();
            String reviewAuthor_Selector = review.select(".author").text();
            String reviewComment_Selector = review.select(".description").text();
            String reviewDate_Selector = review.select(".author span").text();

            System.out.println("reviewTitle_Selector = " + reviewTitle_Selector);
            System.out.println("reviewAuthor_Selector = " + reviewAuthor_Selector);
            System.out.println("reviewComment_Selector = " + reviewComment_Selector);
            System.out.println("reviewDate_Selector = " + reviewDate_Selector);

        }
    }
}
