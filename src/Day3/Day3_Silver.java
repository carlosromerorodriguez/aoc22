package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3_Silver {
    public static void main(String[] args) {
        String abecedario = "[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ]";
        String aux;
        long suma_total = 0;

        File f = new File("aoc-22/src/Day3/output.txt");

        try {
            Scanner entrada = new Scanner(f);

            try {
                while (entrada.hasNextLine()) {
                    String leer = entrada.nextLine();

                    aux = commonChars(leer);
                    for (int i = 1; i < abecedario.length(); i++) {
                        if (abecedario.charAt(i) == aux.charAt(1)) {
                            suma_total += i;
                            break;
                        }
                    }
                }

                System.out.println(suma_total);

            } catch (Throwable var10) {
                try {
                    entrada.close();
                } catch (Throwable var9) {
                    var10.addSuppressed(var9);
                }

                throw var10;
            }

            entrada.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String commonChars (String leer) {
        Set<Character> part1 = new HashSet<>();
        Set<Character> part2 = new HashSet<>();

        //leer parte 1
        for (int i = 0; i < leer.length() / 2; i++) {
            part1.add(leer.charAt(i));
        }
        //leer parte 2
        for (int i = leer.length() / 2; i < leer.length(); i++) {
            part2.add(leer.charAt(i));
        }
        part1.retainAll(part2);
        return part1.toString();
    }
}
