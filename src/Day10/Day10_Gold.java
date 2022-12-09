package Day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day10_Gold {
    public static void main(String[] args) {
        File f = new File("aoc-22/aoc-22/src/Day10/example.txt");
        try {
            Scanner entrada = new Scanner(f);
            while (entrada.hasNextLine()) {
                String linea = entrada.nextLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
