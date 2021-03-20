package utilidades;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class CrossSellSwogo {

    public static void main(String[] args) {

        String target = "https://www.fnac.es/Impresora-multifuncion-HP-DeskJet-2722-Blanco-Impresora-Impresora-multifuncion-inyeccion/a7538577";

        String crossSellUrl = "https://api.swogo.net/JTdCJTIyY2xpZW50JTIyJTNBJTIyZm5hY0VzJTIyJTJDJTIyc2t1cyUyMiUzQSU1QiUyMjEtNzUzODU3NyUyMiU1RCUyQyUyMnR5cGUlMjIlM0ElMjJidW5kbGVzJTIyJTJDJTIybWF0Y2hpbmclMjIlM0ElMjJwZHAlMjIlMkMlMjJhc3Npc3RhbnQlMjIlM0ElMjJwZHAlMjIlMkMlMjJjb25maWd1cmF0aW9uJTIyJTNBJTIyJTdCJTVDJTIybG9uZ1N0eWxlJTVDJTIyJTNBdHJ1ZSU3RCUyMiU3RA==";
        String path = StringUtils.substringAfterLast(crossSellUrl, "/");

        String pathsDecode = decodeContent(path);
        System.out.println("parameters: " + pathsDecode);

        String pathEncode = encodeValue(pathsDecode);

        Document document = null;
        try {
            document = Jsoup.connect(crossSellUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonText = decodeContent(document);
        JsonNode node = null;
        node = getJson(node, jsonText);

        System.out.println("node = " + node);
        JsonNode accessories = node;
        String sku = accessories.at("/hosts/0/sku").asText();
        JsonNode crossSellOffers = accessories.at("/accessories/" + sku +"/0/accessories");
        for(JsonNode reviews: crossSellOffers){
                System.out.println("crossSellOffers = " + reviews.get(0).at(("/title")));
        }

    }

    private static String decodeContent(String path) {
        String jsonContent = new String(Base64.decodeBase64(path.getBytes()));
        String json = null;
        try {
            json = URLDecoder.decode(jsonContent, StandardCharsets.UTF_8.displayName());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return json;
    }

    private static String encodeValue(String value) {
        return Base64.encodeBase64String(value.getBytes());
    }

    private static String decodeContent(Document document) {
        String contentBase64 = document.body().text();
        String jsonContent = new String(Base64.decodeBase64(contentBase64.getBytes()));
        String json = null;
        try {
            json = URLDecoder.decode(jsonContent, StandardCharsets.UTF_8.displayName());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return json;
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
