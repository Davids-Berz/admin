package jlgzz.basic_crawl;


import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.math.BigDecimal;
import java.util.function.Function;

public class OfferSpecification implements Function<Document, Offer> {

    String in_stock = "in_stock";
    String out_stock = "out_stock";
    String availabilityRaw;


    @Override
    public Offer apply(Document document) {

        return new Offer()
                .withUrl(document.select("[rel=canonical]").attr("href"))
                .withTitle(document.select("h1.product-pcel").text())
                .withSku(document.select(".description span:contains(sku)").attr("data-sku"))
                .withMpn(cleanMpn(document))
                .withBrand(document.select("tbody tr:contains(marca) td.value").text())
                .withPriceRaw(document.select("[data-description=price] .price-new").text())
                .withPrice(cleanPrice(document.select("[data-description=price] .price-new").text()))
                .withAvailabilityRaw(isInStok(document))
                .withDelivery_timeRaw(document.select(".description").text())
                .withDeliveryTime(cleanDeliveryTime(document.select(".description").text()));
    }

    private String cleanMpn(Document document){
        String mpn = document.select(".description").text();
        return StringUtils.substringBetween(mpn, "Modelo: ", " Envío");
    }

    private BigDecimal cleanPrice(String priceRaw){
        if(StringUtils.isBlank(priceRaw) || priceRaw == null) return new BigDecimal(0);
        priceRaw = StringUtils.replaceAll(priceRaw,"\\D", "");
        return new BigDecimal(Integer.parseInt(priceRaw)/100);
    }

    private String isInStok(Document document){
        Element availabilityElement = document.select(".addToCart[alt=agregar]").first();
        return availabilityElement != null ? in_stock : out_stock;
    }

    private Integer cleanDeliveryTime(String delivery_timeRaw){
        delivery_timeRaw = StringUtils.substringBetween(delivery_timeRaw, "Envío en: ", " Horas");
        return Integer.parseInt(delivery_timeRaw) / 24;
    }
}
