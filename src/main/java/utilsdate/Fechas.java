package utilsdate;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.time.LocalDate;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fechas {

    public static void main(String[] args) {

        String patter_format = "dd MMM yyyy";
        Locale locale = Locale.forLanguageTag("en-US");
        DateTimeFormatter dtf = DateTimeFormat.forPattern(patter_format).withLocale(locale);

        //-------------

        String rawDelivery = "Доставка курьером ,  10 мая бесплатно";
//        rawDelivery = "10 мая";

        Pattern dayMonthPattern2 = Pattern.compile("\\d+\\s*(января|февраля|март|апреля|мая|июня|июля|август|сентября|октября|ноября|декабря)");
        Matcher dayMonthMatcher2 = dayMonthPattern2.matcher(rawDelivery);
        if (dayMonthMatcher2.find()){
            String dateString = dayMonthMatcher2.group() + " " + getYearNow(dayMonthMatcher2.group(), dtf);
        }

        DateTime dateTime = dtf.parseDateTime(rawDelivery).withZoneRetainFields(DateTimeZone.UTC);

        System.out.println("dateTime = " + dateTime);
    }
    static int getYearNow(String dateDeliveryStr, DateTimeFormatter dtf){
        int yearNow = LocalDate.now().getYear();
        DateTime dateTime;
        dateDeliveryStr = dateDeliveryStr + " " + yearNow;
        if(StringUtils.containsIgnoreCase(dateDeliveryStr, "мая")){
            dateDeliveryStr=dateDeliveryStr.replaceAll("мая?","march");
            dateTime = dtf.parseDateTime(dateDeliveryStr).withZoneRetainFields(DateTimeZone.UTC);
        }
        else{
            dateTime = dtf.parseDateTime(dateDeliveryStr).withZoneRetainFields(DateTimeZone.UTC);
        }
        if (dateTime.isAfter(DateTime.now()) || dateTime.isEqual(dateTime)){
            return yearNow;
        }
        return yearNow + 1;
    }
}
