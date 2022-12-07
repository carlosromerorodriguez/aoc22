package Day6;

import java.io.*;
import java.util.*;

public class Day6_Silver {
    public static void main(String[] args) {
        File f = new File("aoc-22/src/Day6/output.txt");
        try {
            Scanner entrada = new Scanner(f);
            String[] aux = new String[4];
            HashSet <Character> characters = new HashSet<>(4);

            while (entrada.hasNextLine()) {
                String leer = entrada.nextLine();
                for (int i = 0; i < leer.length(); i++) {
                    if (leer.length() > i+3) {
                        for (int j = 0; j < 4; j++) {
                            aux[j] = String.valueOf(leer.charAt(i+j));
                            characters.add(leer.charAt(i+j));
                        }
                        if (aux.length == characters.size()) {
                            System.out.println("Secuencia: "+Arrays.toString(aux)+"\nPosicion: "+(i+4));
                            break;
                        } else { characters.clear(); }
                    } else { break; }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
