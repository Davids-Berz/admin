package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringLibs {
    public static void main(String[] args) {

        String input = "var _0x1ce2c3=_0x1dab('0xe', '½ð¼(j0\u001C1')";
        String r = "var _0x1ce2c3\\s*=\\s*[^(]+\\(('\\(*[\\p{Alnum}|\\p{Punct}]*')[ ]?, ([\\p{ASCII}|\\p{Alnum}|\\p{Punct}|\\p{Print}|½¼¾ðÐ]{0,9}')\\)";
        String regex = "var _0x1ce2c3\\s*=\\s*[^(]+\\(('\\(*[\\p{Alnum}|\\p{Punct}]*')[ ]?, ([\\p{ASCII}|\\p{Alnum}|\\p{Punct}|\\p{Print}|½¼¾ðÐ]{0,9}')\\)";
        String InBasic_Latin = "\\p{InBasic_Latin}";

        Matcher matcher = Pattern.compile(r).matcher(input);

        if(matcher.find()){
            System.out.println(matcher.group(1));
        }

        System.out.println("fin");
    }
}
