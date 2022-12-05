package Day4;

import java.io.*;
import java.util.Scanner;

public class Day4_Silver {
    public static void main(String[] args) {
        File f = new File("aoc-22/src/Day4/example.txt");

        try {
            Scanner entrada = new Scanner(f);
            int cont = 0;

            while (entrada.hasNextLine()) {
                String leer = entrada.nextLine();
                String[] parts = leer.split(",");
                if (containsOneToOther(parts[0], parts[1])) { cont++; }
            }
            System.out.println(cont);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static boolean containsOneToOther(String first, String second) {
        int firstFirst = Integer.parseInt(first.split("-")[0]);
        int firstSecond = Integer.parseInt(first.split("-")[1]);
        int secondFirst = Integer.parseInt(second.split("-")[0]);
        int secondSecond = Integer.parseInt(second.split("-")[1]);

        return (firstFirst <= secondFirst && firstSecond >= secondSecond || firstFirst >= secondFirst && firstSecond <= secondSecond);
    }
}
