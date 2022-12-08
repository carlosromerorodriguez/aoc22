package Day8;

import java.io.*;
import java.util.*;

public class Day8_Silver {
    public static void main(String[] args) {
        File f = new File("aoc-22/aoc-22/src/Day8/output.txt");
        int[][] trees = new int[99][99];
        int left = 0, right = 0, up = 0, down = 0;

        try {
            Scanner entrada = new Scanner(f);
            int cont = 0;

            while (entrada.hasNextLine()) {
                String linea = entrada.nextLine();
                for (int i = 0; i < linea.length(); i++) {
                    trees[cont][i] = Integer.parseInt(String.valueOf(linea.charAt(i)));
                }
                cont++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < trees.length; i++) {
            for (int j = 0; j < trees.length; j++) {
                if (checkCurrentPosition(trees, i, j, 1, 0)) { right++; continue; }
                if (checkCurrentPosition(trees, i, j, -1, 0)) { left++; continue; }
                if (checkCurrentPosition(trees, i, j, 0, 1)) { up++; continue; }
                if (checkCurrentPosition(trees, i, j, 0, -1)) { down++; }
            }
        }
        System.out.println("Output: " + (right+left+up+down));

    }
    private static boolean checkCurrentPosition (int[][] trees, int fila, int col, int horizontal, int vertical) {
        int nextFila = fila + vertical;
        int nextCol = col + horizontal;
        int posActual = trees[fila][col];
        while (nextFila >= 0 && nextFila <= trees.length - 1 && nextCol >= 0 && nextCol <= trees.length - 1) {
            if (posActual <= trees[nextFila][nextCol]) { break; }
            nextFila += vertical; nextCol += horizontal;
        }
        return nextFila < 0 || nextFila > (trees.length - 1) || nextCol < 0 || nextCol > (trees.length - 1);
    }
}
