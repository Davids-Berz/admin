package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MisMatchers {

    public static void main(String[] args) {

        String deliveryRaw = "Lieferung 2-3 Werktage";
        Matcher deliveryMatcher2 = Pattern.compile("(\\d+)-(\\d+) werktage").matcher(deliveryRaw.toLowerCase());
        if (deliveryMatcher2.find()) {

            System.out.println(deliveryMatcher2.group(2));
        }
    }
}
