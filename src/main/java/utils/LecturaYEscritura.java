package utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LecturaYEscritura {
    public static void main(String[] args) {
        final String SITE = "MundoBebes";
        Path path = Paths.get("D:\\David\\tickets\\workit\\cp\\expert\\expert-de.html");
        List<String> str = null;
        try {
            str = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document doc = Jsoup.parse(str.toString(), "", Parser.htmlParser());

        Elements products = doc.select("products product");
        // total de productos
        System.out.println(products.size());
        int count = 0;
        for (Element product : products) {
            System.out.println("Producto N° " + count);

            // name
            String name = product.select("name").text();
            System.out.println("name = " + name);
            //url
            String url = product.select("url").text();
            System.out.println("url = " + url);
            //sku
            String sku = product.attr("ID");
            if (sku.length() < 4) sku = SITE + "_" + sku;
            System.out.println("sku = " + sku);
            // img
            String image = product.select("images image").text();
            System.out.println("image = " + image);
            //price
            String price = product.select("properties [name=fromPrice]").text();
            System.out.println("price = " + price);
            //brand
            String brand = product.select("properties [name=brand]").text();
            System.out.println("brand = " + brand);
            //ean
            String GTIN13 = product.select("properties [name=GTIN]").text();
            System.out.println("GTIN13 = " + GTIN13);
            //avail
            String availability = product.select("properties [name=availability]").text();
            System.out.println("availability = " + availability);
            //stock
            String inStock = product.select("properties [name=stock]").text();
            //category
            String category = product.select("categories category").attr("path");
            System.out.println("category = " + category);

            count++;
            System.out.println();
        }


    }
}
