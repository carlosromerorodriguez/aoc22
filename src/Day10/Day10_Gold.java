package Day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Cycle   1 -> ######################################## <- Cycle  40
Cycle  41 -> ######################################## <- Cycle  80
Cycle  81 -> ######################################## <- Cycle 120
Cycle 121 -> ######################################## <- Cycle 160
Cycle 161 -> ######################################## <- Cycle 200
Cycle 201 -> ######################################## <- Cycle 240

CPU-> X
 */

public class Day10_Gold {
    public static void main(String[] args) {
        File f = new File("aoc-22/aoc-22/src/Day10/output.txt");
        try {
            Scanner entrada = new Scanner(f);
            int register = 1, cycle = 0;
            int[] jumpLine = { 40, 80, 120, 160, 200, 240 };
            StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("#".repeat(240));

            while (entrada.hasNextLine()) {
                String linea = entrada.nextLine();

                if (linea.contains("addx")) {
                    String[] parts = linea.split(" ");
                    int num = Integer.parseInt(parts[1]);

                    stringBuilder.setCharAt(cycle % 240, Math.abs (register - (cycle % 40)) <= 1 ? '█' : '.'); cycle += 1;
                    stringBuilder.setCharAt(cycle % 240, Math.abs (register - (cycle % 40)) <= 1 ? '█' : '.'); cycle += 1;
                    register += num;
                } else { stringBuilder.setCharAt(cycle % 240, Math.abs (register - (cycle % 40)) <= 1 ? '█' : '.'); cycle += 1; }
            }
            System.out.println("Output:\n");
            String output = String.valueOf(stringBuilder);
            for (int i = 0; i < output.length(); i++) { System.out.print(output.charAt(i)); for (int k : jumpLine) { if (i == k - 1) { System.out.println(); } } }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
