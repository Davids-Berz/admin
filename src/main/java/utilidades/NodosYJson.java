package utilidades;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NodosYJson {

    public static void main(String[] args) {

        String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
        JsonNode jsonNode = null;
        try {
            jsonNode = new ObjectMapper().readTree(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String color = jsonNode.get("color").asText();
        String colorAt = jsonNode.at("/color").asText();

        System.out.println("el color es: " + color);
        System.out.println("el colorAt es: " + colorAt);
    }
}
