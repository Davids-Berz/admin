package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NodosYJson {

    public static void main(String[] args) {

        String json = "{\"arrayColores\":[{\"nombreColor\":\"rojo\",\"valorHexadec\":\"#f00\"},{\"nombreColor\":\"verde\",\"valorHexadec\":\"#0f0\"},{\"nombreColor\":\"azul\",\"valorHexadec\":\"#00f\"},{\"nombreColor\":\"cyan\",\"valorHexadec\":\"#0ff\"},{\"nombreColor\":\"negro\",\"valorHexadec\":\"#000\"}]}";
        JsonNode node = null;
        try {
            node = new ObjectMapper().readTree(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        JsonNode nodeColores = node.at("/arrayColores");

        System.out.println("la suma de todos los colores es: " + nodeColores.size());

        for (JsonNode color: nodeColores){
            System.out.println(color.at("/nombreColor").asText() + " - " + color.at("/valorHexadec").asText());
        }

    }
}
