package jlgzz;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.math.BigDecimal;

public class
Ejercicio_3 {

    public static void main(String[] args) {

        String in_stock = "in_stock";
        String out_stock = "out_stock";
        String availabilityRaw;
        String target = "https://pcel.com/hardware/procesadores/AMD-100-100000065BOX-Procesador-AMD-Ryzen-5-5600X-de-Quinta-Generacion-3-7GHz-hasta-4-6GHz-Socket-AM4-Six-Core-65W-374056";
        Document document = null;

        try {
            document = Jsoup.connect(target).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String title = document.select("h1.product-pcel").text();

        String sku = document.select(".description span:contains(sku)").attr("data-sku");

        String mpn = document.select(".description").text();
        //mpn = StringUtils.substringBetween(mpn, "Modelo: ", " Envío");

        String priceRaw = document.select("[data-description=price] .price-new").text();
        priceRaw = StringUtils.replaceAll(priceRaw,"\\D", "");
        BigDecimal price = new BigDecimal(Integer.parseInt(priceRaw)/100);


        Element availabilityElement = document.select(".addToCart[alt=agregar]").first();

        String availability = availabilityElement != null ? in_stock : out_stock;

        /*if (availabilityElement != null) {
            availabilityRaw = in_stock;
        }else{
         availabilityRaw = out_stock;
        }*/

        String brand = document.select("tbody tr:contains(marca) td.value").text();

        String delivery_timeRaw = document.select(".description").text();
        //delivery_timeRaw = StringUtils.substringBetween(delivery_timeRaw, "Envío en: ", " Horas");
        //Integer deliveryTime = Integer.parseInt(delivery_timeRaw) / 24;

        System.out.println("title = " + title);
        System.out.println("sku = " + sku);
        System.out.println("mpn = " + mpn);
        System.out.println("priceRaw = " + priceRaw);
        System.out.println("price = " + price);
        System.out.println("availabilityElement = " + availabilityElement);
        System.out.println("availabilityRaw = " + availability);
        System.out.println("brand = " + brand);
        System.out.println("delivery_timeRaw = " + delivery_timeRaw);
        //System.out.println("deliveryTime = " + deliveryTime);
    }
}
