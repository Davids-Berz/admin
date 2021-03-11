package utilidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Listas {

    public static void main(String[] args) {

        List<Integer> valores = Arrays.asList(1,2,3,4);

        valores = valores.stream().filter(x ->x>1).collect(
                Collectors.toCollection(() -> new ArrayList<>()));

        System.out.println(valores.size());
    }
}
