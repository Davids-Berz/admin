package jlgzz;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.math.BigDecimal;

public class Ejercicio_3_1 {

    public static void main(String[] args) {

        String in_stock = "in_stock";
        String out_stock = "out_stock";
        String availabilityRaw;
        String target = "https://www.costco.com.mx/Electronicos/Videojuegos/Xbox/Xbox-Control-Inalambrico-Robot-Blanco/p/663096";
        Document document = null;

        try {
            document = Jsoup.connect(target).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String title = document.select(".product-name").first().text();

        String sku = document.select(".hidden-xs .product-code span").text();

        String brand = document.select("tr:contains(Marca) td.attrib-val").text();

        String mpn = document.select("tr:contains(Modelo) td.attrib-val").text();

        String priceRaw = document.select(".price-original span.notranslate").text();
        priceRaw = StringUtils.replaceAll((priceRaw),"\\D","");

        BigDecimal price = new BigDecimal(Integer.parseInt(priceRaw)/100);



        String delivery_timeRaw = document.select("p:nth-of-type(1) strong").text();
        //delivery_timeRaw = StringUtils.substringBetween(delivery_timeRaw, "a ", " días");
        //Integer deliveryTime = Integer.parseInt(delivery_timeRaw) / 24;


        System.out.println("title = " + title);
        System.out.println("sku = " + sku);
        System.out.println("brand = " + brand);
        System.out.println("mpn = " + mpn);
        System.out.println("priceRaw = " + priceRaw);
        System.out.println("price = " + price);
        //System.out.println("availabilityElement = " + availabilityElement);
        //System.out.println("availabilityRaw = " + availability);

        System.out.println("delivery_timeRaw = " + delivery_timeRaw);
        //System.out.println("deliveryTime = " + deliveryTime);
    }
}
