package examen;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Empezar {

    public static void main(String[] args) throws ParseException {

        Calendar same = Calendar.getInstance();

        List<Prestamos> prestamosLts = Arrays.asList(
                new Prestamos(103228, 1, "10/01/2021", 37500.12, "pendiente")
        );
        MontoPago(prestamosLts);
    }

    static List<Prestamos> MontoPago(List<Prestamos> prestamos) throws ParseException {
        List<Prestamos> prestamosList = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("###.##");
        Integer plazo;
        double interes;
        double iva;
        double pago;

        for (Prestamos p : prestamos) {
            plazo = diffFecha(p.getFecha());
            interes = p.getMonto() * plazo * tasas(plazo) / 360;
            iva = interes * 1.16;
            pago = p.getMonto() + interes + iva;
            pago = Double.parseDouble(df.format(pago));
            p.setPago(pago);
            prestamosList.add(p);
            System.out.println(p.toString());
        }
        return prestamosList;
    }

    static Integer diffFecha(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse("15/02/2021");
        Date secondDate = sdf.parse(date);

        long diff = firstDate.getTime() - secondDate.getTime();

        TimeUnit time = TimeUnit.DAYS;
        Integer diffrence = Math.toIntExact(time.convert(diff, TimeUnit.MILLISECONDS));
        System.out.println("The difference in days is : " + diffrence);
        return diffrence;
    }

    static double tasas(Integer plazo) {
        if (plazo == 1) return 7.0f;
        else if (plazo >= 2 && plazo <= 7) return 6.5;
        else if (plazo >= 8 && plazo <= 15) return 6.0;
        else if (plazo >= 16 && plazo <= 30) return 5.5;
        else if (plazo >= 31 && plazo <= 360) return 5.0;
        return 0f;
    }
}
