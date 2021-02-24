package jlgzz.basic_crawl;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class ListingPage {

    public static void main(String[] args) {

        final String Target = "https://pcel.com/hardware/procesadores";

        final String NEXT_PAGE_URL = ".links a:contains(>):not(:contains(|))";
        String nextPageUrl;
        List<Offer> offerLink = new ArrayList<>();

//        conexion de listing - Handling Offer links and  Next Page
        Document documento = null;
        try {
            documento = Jsoup.connect(Target).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean nextPage = documento.select(NEXT_PAGE_URL).hasText();
        System.out.println(documento.title());
        nextPageUrl = documento.select(NEXT_PAGE_URL).attr("href");
        System.out.println(nextPageUrl);
        int count = 0;

        while (nextPage && StringUtils.startsWithIgnoreCase(nextPageUrl, "https://")) {

            offerLink = getOfferLinks(offerLink, documento);

            try {
                documento = Jsoup.connect(nextPageUrl).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(documento.title());
            nextPageUrl = documento.select(NEXT_PAGE_URL).attr("href");
            System.out.println(nextPageUrl);
        }
//        ir por ofertas.

        for (int i = 0; i < offerLink.size()-1; i++) {
            try {
                documento = Jsoup.connect(offerLink.get(i).getUrl()).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
            Offer offer = new OfferSpecification().apply(documento);
            System.out.println("url = " + offer.getUrl());
            System.out.println("title = " + offer.getTitle());
            System.out.println("sku = " + offer.getSku());
            System.out.println("mpn = " + offer.getMpn());
            System.out.println("priceRaw = " + offer.getPriceRaw());
            System.out.println("price = " + offer.getPrice());
            System.out.println("availabilityElement = " + offer.getAvailabilityRaw());
            System.out.println("availabilityRaw = " + offer.getAvailabilityRaw());
            System.out.println("brand = " + offer.getBrand());
            System.out.println("delivery_timeRaw = " + offer.getDelivery_timeRaw());
            System.out.println("deliveryTime = " + offer.getDeliveryTime());
            System.out.println("count: " + i);
        }

        System.out.println("termina");
    }

    private static List<Offer> getOfferLinks(List<Offer> list, Document document) {
//        List<Offer> offers = new ArrayList<>();
        Elements offersElements = document.select(".product-list table   tbody   tr .name a");
        for (Element offer : offersElements) {
            list.add(new Offer(offer.text(), offer.attr("href")));
        }
        return list;
    }
}
