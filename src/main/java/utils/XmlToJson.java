package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.IOException;

public class XmlToJson {

    public static void main(String[] args) {

        String target = "https://www.costco.com.mx/rest/v2/mexico/products/search?fields=FULL&query=&pageSize=24&category=cos_1.1&lang=es_MX&curr=MXN";

        Document documento = null;
        try {
            documento = Jsoup.connect(target).parser(Parser.xmlParser())
                    .header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                    .header("cookie","ak_bmsc=9C442C3F04C15FA3B0E038172F1754EDB81C7237E13500007EFB46605E4FEA34~plWPrbBrWK3tXThnS2qtvbZK0dK54MR+I3/nuU44GBRAYnd1c+a0TB8UXiibTFAxSJTALbLk+a+R77slDMphaHtV+YI4mLQDk4ByP56UjCUCGvl2/yCo2YKfzpixH6D+WI4uPBTtgD3rO8EyOpQjon4tWnE8xOeJbqsA46xMU9n1hMjpJrYEf505ziMSBtF+G5hZfj57S/RaRBivuj+Nd/P78NZ3JJkASl/63H7E/kP/g=; GCLB=COT6i-XrnYmEbQ; HAPC=fe01").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonText = documento.toString();
        JsonNode node = null;
        node = getJson(node, jsonText);
    }

    private static JsonNode getJson(JsonNode node, String jsonText) {
        try {
            node = new ObjectMapper().readTree(jsonText);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return node;
    }
}

