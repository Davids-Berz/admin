package utilidades;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class CrossSellSwogo {

    public static void main(String[] args) {

        String crossSellUrl = "https://api.swogo.net/JTdCJTIyY2xpZW50JTIyJTNBJTIyZm5hY0VzJTIyJTJDJTIyc2t1cyUyMiUzQSU1QiUyMjEtMTQ4MzM5NyUyMiU1RCUyQyUyMnR5cGUlMjIlM0ElMjJidW5kbGVzJTIyJTJDJTIybWF0Y2hpbmclMjIlM0ElMjJwZHAlMjIlMkMlMjJhc3Npc3RhbnQlMjIlM0ElMjJwZHAlMjIlMkMlMjJjb25maWd1cmF0aW9uJTIyJTNBJTIyJTdCJTVDJTIybG9uZ1N0eWxlJTVDJTIyJTNBdHJ1ZSU3RCUyMiU3RA==";
        String parameters = null;
        try {
            parameters = URLDecoder.decode("%7B%22client%22%3A%22fnacEs%22%2C%22skus%22%3A%5B%221-1483397%22%5D%2C%22type%22%3A%22bundles%22%2C%22matching%22%3A%22pdp%22%2C%22assistant%22%3A%22pdp%22%2C%22configuration%22%3A%22%7B%5C%22longStyle%5C%22%3Atrue%7D%22%7D", StandardCharsets.UTF_8.displayName());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("parameters: " + parameters);
//        {"client":"fnacEs","skus":["1-7538577"],"type":"bundles","matching":"pdp","assistant":"pdp"}
//        {"client":"fnacEs","skus":["1-1483397"],"type":"bundles","matching":"pdp","assistant":"pdp","configuration":"{\"longStyle\":true}"} Impresora HP LaserJet Pro M15w Blanco

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
