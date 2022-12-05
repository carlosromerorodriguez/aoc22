package Day1;

import java.io.*;
import java.util.*;

public class Day1_Gold {
    public Day1_Gold() {
    }

    public static void main(String[] args) {
        int sumaInt = 0;
        int i = 0;
        String espacio;
        int[] numeros = new int[2300];
        File f = new File("aoc-22/src/Day1/example.txt");

        try {
            Scanner entrada = new Scanner(f);

            try {
                while(entrada.hasNextLine()) {
                    espacio = entrada.nextLine();
                    if (espacio.isEmpty()) {
                        numeros[i] = sumaInt;
                        sumaInt = 0;
                        ++i;
                    } else {
                        sumaInt += Integer.parseInt(espacio);
                    }
                }

                Arrays.sort(numeros);
                int suma = numeros[numeros.length - 1] + numeros[numeros.length - 2] + numeros[numeros.length - 3];
                System.out.println(suma);
            } catch (Throwable var11) {
                try {
                    entrada.close();
                } catch (Throwable var10) {
                    var11.addSuppressed(var10);
                }

                throw var11;
            }

            entrada.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
