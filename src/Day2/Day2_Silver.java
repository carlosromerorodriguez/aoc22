package Day2;

import java.io.*;
import java.util.Scanner;

public class Day2_Silver {
        public static void main(String[] args) {
        int resultado = 0;
        File f = new File("src/Day2/output.txt");

        try {
            Scanner entrada = new Scanner(f);

            try {
                while(entrada.hasNextLine()) {
                    String leer = entrada.nextLine();
                    char opponent = leer.charAt(0);
                    char me = leer.charAt(2);
                    if (opponent == 'A') {
                        if (me == 'X') {
                            resultado += 4;
                        } else if (me == 'Y') {
                            resultado += 8;
                        } else {
                            resultado += 3;
                        }
                    } else if (opponent == 'B') {
                        if (me == 'Y') {
                            resultado += 5;
                        } else if (me == 'Z') {
                            resultado += 9;
                        } else {
                            ++resultado;
                        }
                    } else if (opponent == 'C') {
                        if (me == 'Z') {
                            resultado += 6;
                        } else if (me == 'X') {
                            resultado += 7;
                        } else {
                            resultado += 2;
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
