package Day9;

import java.io.*;
import java.util.*;

public class Day9_Gold {
    public static void main(String[] args) {
        File f = new File("aoc-22/aoc-22/src/Day9/example.txt");
        try {
            Scanner entrada = new Scanner(f);
            while (entrada.hasNextLine()) {
                String linea = entrada.nextLine();
                System.out.println(linea);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
