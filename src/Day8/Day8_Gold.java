package Day8;

import java.io.*;
import java.util.*;

public class Day8_Gold {
    public static void main(String[] args) {
        File f = new File("aoc-22/aoc-22/src/Day8/output.txt");
        int[][] trees = new int[99][99];
        int left, right, up, down, max = Integer.MIN_VALUE;

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
                right = sumTreesFromCurrentPosition(trees, i, j, 1, 0);
                left = sumTreesFromCurrentPosition(trees, i, j, -1, 0);
                up = sumTreesFromCurrentPosition(trees, i, j, 0, 1);
                down = sumTreesFromCurrentPosition(trees, i, j, 0, -1);
                if ((right*left*up*down) > max) { max = (right*left*up*down); }
            }
        }
        System.out.println("Output: " + max);

    }
    private static int sumTreesFromCurrentPosition (int[][] trees, int fila, int col, int horizontal, int vertical) {
        int nextFila = fila + vertical;
        int nextCol = col + horizontal;
        int posActual = trees[fila][col];
        int cont = 0;
        while (nextFila >= 0 && nextFila <= trees.length - 1 && nextCol >= 0 && nextCol <= trees.length - 1) {
            cont++;
            if (posActual <= trees[nextFila][nextCol]) { break; }
            nextFila += vertical; nextCol += horizontal;
        }
        return cont;
    }
}
