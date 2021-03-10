package jlgzz;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.json.XML;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.IOException;

public class CostcoTest {

    public static void main(String[] args) {

        String segment = "https://www.costco.com.mx/Electronicos/Pantallas-y-Proyectores/c/cos_1.1";
        String REQUEST_URL = "https://www.costco.com.mx/rest/v2/mexico/products/search?fields=FULL&query=&pageSize=24&category=/category/";

        String category = StringUtils.substringAfterLast(segment, "/"); // cos_1.1
        String buildUrl = StringUtils.replace(REQUEST_URL, "/category/", category);
        buildUrl = StringUtils.join(buildUrl, "&currentPage=", 0);

       // peticion con Jsoup
        Document doc = null;
        try {
            doc = Jsoup.connect(buildUrl).parser(Parser.xmlParser())
                    .header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //obtiene la info del XML en String
        String xml = doc.toString();

        // Se obtiene un String de un Xml
        String json = XML.toJSONObject(xml).toString();

        JsonNode node = null;
        try {
            node = new ObjectMapper().readTree(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // productos desde un jsonNode

        JsonNode products = node.at("/productCategorySearchPage/products");

        System.out.println("ofertas: " + products.size());

        for(JsonNode product: products){
            String url = product.at("/url").asText();
            String title = product.at("/name").asText();
            String price = product.at("/price/value").asText();

            System.out.println("url = " + url);
            System.out.println("title = " + title);
            System.out.println("price = " + price);
        }


    }
}
