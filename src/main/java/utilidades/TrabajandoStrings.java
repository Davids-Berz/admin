package utilidades;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

public class TrabajandoStrings {

    public static void main(String[] args) {


        /*
        1.- tomas un substring hasta el primer punto
        2.- cambiar caracter de espacio por el espacio
        3.- tomar el valor «sinopsis», (sin caracteres)y guardarlo en una variable
        * */
        String frase = "Una sinopsis es un resumen general de una obra en particular.\u200B El término «sinopsis» procede del latín «synopsis», cuyos orígenes se remontan al griego antiguo y que etimológicamente significa visión de conjunto, \u200B de las raíces griegas συν y οψις.";
        String priceRaw = "349:-";

        String subString = StringUtils.substringAfter(frase, ".");
        String price = StringUtils.replaceAll(priceRaw, "\\D", "").trim();

        System.out.println(price);
    }
}
