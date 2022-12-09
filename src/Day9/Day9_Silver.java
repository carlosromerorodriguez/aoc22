package Day9;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Day9_Silver {
    public static void main(String[] args) {
        File f = new File("aoc-22/aoc-22/src/Day9/output.txt");
        Set<Object> hashtag = new HashSet<>();
        Point head = new Point(0, 0); Point tail = new Point(0, 0);

        try {
            Scanner entrada = new Scanner(f);

            while (entrada.hasNextLine()) {
                String[] linea = entrada.nextLine().split(" ");

                if (linea[0].equals("U")) {
                    for (int i = 0; i < Integer.parseInt(linea[1]); i++) {
                        head = new Point(head.x - 1, head.y);
                        if (head.x - tail.x < -1) { //diagonal
                            tail = new Point(tail.x - 1, head.y);
                            hashtag.add(tail);
                        }
                    }
                } else if (linea[0].equals("D")) {
                    for (int i = 0; i < Integer.parseInt(linea[1]); i++) {
                        head = new Point(head.x + 1, head.y);
                        if (head.x - tail.x > 1) { //diagonal
                            tail = new Point(tail.x + 1, head.y);
                            hashtag.add(tail);
                        }
                    }
                } else if (linea[0].equals("L")) {
                    for (int i = 0; i < Integer.parseInt(linea[1]); i++) {
                        head = new Point(head.x, head.y - 1);
                        if (head.y - tail.y < -1) { //diagonal
                            tail = new Point(head.x, tail.y - 1);
                            hashtag.add(tail);
                        }
                    }
                } else if (linea[0].equals("R")) {
                    for (int i = 0; i < Integer.parseInt(linea[1]); i++) {
                        head = new Point(head.x, head.y + 1);
                        if (head.y - tail.y > 1) { //diagonal
                            tail = new Point(head.x, tail.y + 1);
                            hashtag.add(tail);
                        }
                    }
                }
            }
            System.out.println("Output: " + hashtag.size());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
