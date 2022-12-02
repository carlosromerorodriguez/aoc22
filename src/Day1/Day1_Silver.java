package Day1;

import java.io.*;
import java.util.Scanner;

public class Day1_Silver {
    public Day1_Silver() {
    }

    public static void main(String[] args) {
        int sumaInt = 0;
        int max = 0;
        File f = new File("src/Day1/output.txt");

        try {
            Scanner entrada = new Scanner(f);

            try {
                while(entrada.hasNextLine()) {
                    String leer = entrada.nextLine();
                    if (leer.isEmpty()) {
                        if (sumaInt > max) {
                            max = sumaInt;
                        }

                        sumaInt = 0;
                    } else {
                        sumaInt += Integer.parseInt(leer);
                    }
                }

                System.out.println(max);
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
