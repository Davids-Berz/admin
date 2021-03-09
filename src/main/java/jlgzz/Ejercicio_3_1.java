package jlgzz;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

        Element availabilityElement = document.select("#addToCartButton:contains(Agregar al Carrito)").first();

        String availability = availabilityElement != null ? in_stock : out_stock;

        String ImagePath = document.select("[property=og:image]").attr("content");

        String ProductPath = document.select("[rel=canonical]").attr("href");

        String delivery_timeRaw = document.select("p:nth-of-type(1) strong").text();

        String delivery = StringUtils.substringBetween(delivery_timeRaw, "a ", " días");

        Integer RawDelivery = Integer.parseInt(delivery) / 24;


        System.out.println("title = " + title);
        System.out.println("sku = " + sku);
        System.out.println("brand = " + brand);
        System.out.println("mpn = " + mpn);
        System.out.println("priceRaw = " + priceRaw);
        System.out.println("price = " + price);
        System.out.println("availabilityElement = " + availabilityElement);
        System.out.println("availability = " + availability);
        System.out.println("Image = " + ImagePath);
        System.out.println("ProductPath = " + ProductPath);
        System.out.println("delivery_timeRaw = " + delivery_timeRaw);
        System.out.println("delivery = " + delivery);
    }
}
