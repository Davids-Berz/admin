package utils;

public class Iteraciones {

    public static void main(String[] args) {

        int[] numeros = {1,2,3,4,5,6,7,8,9};

        for(int i : numeros){
            if(i == 5) continue;
            System.out.print(i + " ");
        }

    }
}
