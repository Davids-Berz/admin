package utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.Period;

public class TrabajandoStrings {

    public static void main(String[] args) {

        String deliveryRaw = "de 2 a 5 dias";

        String delivery = StringUtils.replaceAll(deliveryRaw, "\\D", "").substring(1);
        Period period = Period.ofDays(Integer.parseInt(delivery));
        System.out.println("delivery = " + period);

        /*
        1.- tomas un substring hasta el primer punto
        2.- cambiar caracter de espacio por el espacio
        3.- tomar el valor «sinopsis», (sin caracteres)y guardarlo en una variable
        4.- cambiar String priceRaw a BigDecimal
        * */
        String frase = "Una sinopsis es un resumen general de una obra en particular.\u200B El término «sinopsis» procede del latín «synopsis», cuyos orígenes se remontan al griego antiguo y que etimológicamente significa visión de conjunto, \u200B de las raíces griegas συν y οψις.";
        String priceRaw = "$349";

        //1.- tomas un substring hasta el primer punto
        System.out.println(frase.substring(0,60));

        //2.- cambiar caracter de espacio por el espacio
        String target = "\u200B";
        String replacement = " ";
        System.out.println(frase.replace(target,replacement));

        //3.- tomar el valor «sinopsis», (sin caracteres)y guardarlo en una variable
        String sinopsis = frase.substring(75,83);
        System.out.println(sinopsis);

        //4.- cambiar String priceRaw a BigDecimal
        String s = priceRaw.substring(1,4);
        BigDecimal bd = new BigDecimal(s);
        System.out.println(bd);
    }
}
