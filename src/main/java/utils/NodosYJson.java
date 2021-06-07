package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NodosYJson {

    public static void main(String[] args) {

        String json = "{\n" +
                "   \"name\":\"Brother LC-1000BK, LC1000BK, Cartucho de Tinta, Innobella, Negro\",\n" +
                "   \"sku\":\"39846\",\n" +
                "   \"image\":\"https://raja.scene7.com/is/image/Raja/products/brother-lc-1000bk-lc1000bk-cartucho-tinta-innobella-negro_39846.jpg?image=asset1427810$default$&hei=300&wid=300\",\n" +
                "   \"aggregateRating\":{\n" +
                "      \"ratingValue\":1.0,\n" +
                "      \"reviewCount\":1,\n" +
                "      \"@type\":\"AggregateRating\"\n" +
                "   },\n" +
                "   \"description\":\"Este cartucho de tinta negra original Brother LC1000BK ofrece impresiones de alta calidad con resultados llamativos Fabricado para su uso con equipos Brother, esta tinta a prueba de manchas y resistente a la decoloración ofrece impresiones duraderas, generando una amplia escala de grises y tonos negros intensos. Los consumibles originales Brother garantizan una mayor duración de la vida útil de su equipo y proporcionan resultados óptimos con la calidad deseada. Color: negro Impresiones más duraderas Secado rápido Colores resistentes a la luz Rendimiento: hasta 300 páginas Fabricado para las siguientes impresoras: ver pestaña “Impresoras compatibles”\",\n" +
                "   \"offers\":{\n" +
                "      \"availability\":\"http://schema.org/InStock\",\n" +
                "      \"price\":22.49,\n" +
                "      \"priceCurrency\":\"EUR\",\n" +
                "      \"url\":\"https://www.kalamazoo.es/cartuchos-y-toneres_sku39846.html\",\n" +
                "      \"@type\":\"Offer\"\n" +
                "   },\n" +
                "   \"review\":[\n" +
                "      {\n" +
                "         \"name\":\"HE ENCONTRADO UNO COMPATIBLE QUE NO VALE NI TRES EUROS\",\n" +
                "         \"datePublished\":\"22/02/2019\",\n" +
                "         \"description\":\"HE ENCONTRADO UNO COMPATIBLE QUE NO VALE NI TRES EUROS\",\n" +
                "         \"author\":{\n" +
                "            \"name\":\"trust\",\n" +
                "            \"@type\":\"Thing\"\n" +
                "         },\n" +
                "         \"reviewRating\":{\n" +
                "            \"worstRating\":1,\n" +
                "            \"bestRating\":1,\n" +
                "            \"ratingValue\":1,\n" +
                "            \"@type\":\"Rating\"\n" +
                "         },\n" +
                "         \"@type\":\"review\"\n" +
                "      }\n" +
                "   ],\n" +
                "   \"@context\":\"http://schema.org\",\n" +
                "   \"@type\":\"Product\"\n" +
                "}";



        Elements doc.select("script");
        String json = "";
        for(Elements script : script){
            if(StringUtils.containsIgnoreCase("itemListElement")){
                script.data();
            }
        }


        JsonNode node = null;
        try {
            node = new ObjectMapper().readTree(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        JsonNode nombre = node.at("/review");


        System.out.println("la suma de todos los colores es: " + nombre.size());


    }
}
