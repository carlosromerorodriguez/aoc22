package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3_Gold {
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
                    String leer1 = entrada.nextLine();
                    String leer2 = entrada.nextLine();

                    aux = commonChars(leer, leer1, leer2);

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

    private static String commonChars (String leer, String leer1, String leer2) {
        Set<Character> part1 = new HashSet<>();
        Set<Character> part2 = new HashSet<>();
        Set<Character> part3 = new HashSet<>();

        for (int i = 0; i < leer.length(); i++) {
            part1.add(leer.charAt(i));
        }
        for (int i = 0; i < leer1.length(); i++) {
            part2.add(leer1.charAt(i));
        }
        for (int i = 0; i < leer2.length(); i++) {
            part3.add(leer2.charAt(i));
        }
        part1.retainAll(part2);
        part1.retainAll(part3);

        return part1.toString();
    }

}
