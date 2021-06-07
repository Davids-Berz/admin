package utils;

import org.joda.time.Period;

import java.math.BigDecimal;

public class Periodos {

    public static void main(String[] args) {

        Period p = new Period().withDays(1);
        BigDecimal bd = new BigDecimal(-1);

        System.out.println("p = " + p);
        System.out.println("bd = " + bd);
    }
}
