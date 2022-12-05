package Day2;

import java.io.*;
import java.util.Scanner;

public class Day2_Gold {
    public static void main(String[] args) {
        int resultado = 0;
        File f = new File("aoc-22/src/Day2/example.txt");

        try {
            Scanner entrada = new Scanner(f);

            try {
                while(entrada.hasNextLine()) {
                    String leer = entrada.nextLine();
                    char opponent = leer.charAt(0);
                    char me = leer.charAt(2);
                    if (opponent == 'A') {
                        if (me == 'X') {
                            resultado += 3;
                        } else if (me == 'Y') {
                            resultado += 4;
                        } else {
                            resultado += 8;
                        }
                    } else if (opponent == 'B') {
                        if (me == 'X') {
                            ++resultado;
                        } else if (me == 'Y') {
                            resultado += 5;
                        } else {
                            resultado += 9;
                        }
                    } else if (opponent == 'C') {
                        if (me == 'X') {
                            resultado += 2;
                        } else if (me == 'Y') {
                            resultado += 6;
                        } else {
                            resultado += 7;
                        }
                    }
                }

                System.out.println(resultado);
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
}
