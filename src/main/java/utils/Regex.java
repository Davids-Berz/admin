package utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {

        String precio = "123.10";
        String plus = "uno+dos";
        String regex = "^[\\d]*[.][\\d]{2}";
        String regexPlus = "\\+";
        Matcher matcher = Pattern.compile(regex).matcher(precio);
        Matcher matcherPlus = Pattern.compile(regexPlus).matcher(plus);

        System.out.println(matcherPlus.find());
        System.out.println(StringUtils.replaceAll(plus, "[+]", "%20"));

    }
}
