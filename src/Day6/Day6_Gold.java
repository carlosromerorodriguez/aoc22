package Day6;

import java.io.*;
import java.util.*;

public class Day6_Gold {
    public static void main(String[] args) {
        File f = new File("aoc-22/src/Day6/example.txt");
        try {
            Scanner entrada = new Scanner(f);

            while (entrada.hasNextLine()) {
                String leer = entrada.nextLine();
                System.out.println(leer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
