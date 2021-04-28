package Etuyo;

import org.apache.commons.lang3.StringUtils;

public class Crawl {
    public static void main(String[] args) {

        String CARACTERE_ESPACE = "" + Character.toChars(160)[0];

        String availavility = "Disponible en stock (entrega 2-5 días laborables según zona)";

        availavility = StringUtils.substringBefore(availavility, "(");

        System.out.println(availavility);

        System.out.println(StringUtils.containsIgnoreCase(availavility,"en stock"));

        String text = "Precio de envío a pié de calle 10.73€ ud.";
        text = StringUtils.replacePattern(text, "[^0-9.]", "");
        text = StringUtils.substringBeforeLast(text, ".");
        System.out.println("text = " + text);

        /*String url = "https://www.etuyo.es/es/emisores-termoelectricos-mejor-precio/16048-emisor-termico-digital-haverland-750-w-rc6tt-emisores-termoelectricos-8423055002218.html";

        url = StringUtils.substringAfterLast(url , "-");
        url = StringUtils.replacePattern(url, "\\D", "");
        System.out.println("url = " + url);*/
    }
}
