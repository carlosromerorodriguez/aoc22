package Day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
intensidad de la señal (el número de ciclo multiplicado por el valor del Xregistro
durante el ciclo 20 y cada 40 ciclos posteriores (es decir, durante los ciclos 20, 60, 100, 140, 180 y 220).
 */

public class Day10_Silver {
    public static void main(String[] args) {
        File f = new File("aoc-22/aoc-22/src/Day10/output.txt");
        try {
            Scanner entrada = new Scanner(f);
            int register = 1, cycle = 0;
            int suma = 0;
            int[] intensity = { 20, 60, 100, 140, 180, 220 };

            while (entrada.hasNextLine()) {
                String linea = entrada.nextLine();

                if (linea.contains("addx")) {
                    String[] parts = linea.split(" ");
                    int num = Integer.parseInt(parts[1]);

                    cycle += 1; for (int j : intensity) { if (cycle == j) { suma += register * cycle; } }
                    cycle += 1; for (int j : intensity) { if (cycle == j) { suma += register * cycle; } }

                    register += num;

                } else { cycle += 1; for (int j : intensity) { if (cycle == j) { suma += register * cycle; } } }
            }
            System.out.println("Output: " + suma);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
