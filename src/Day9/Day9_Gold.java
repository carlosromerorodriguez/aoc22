package Day9;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Day9_Gold {
    public static void main(String[] args) {
        File f = new File("aoc-22/aoc-22/src/Day9/output.txt");
        Set<Object> hashtagsNine = new HashSet<>();
        LinkedList<Point> pointsNine = new LinkedList<>(); for (int i = 0; i < 10; i++) { pointsNine.add (new Point(0, 0)); }

        try {
            Scanner entrada = new Scanner(f);

            while (entrada.hasNextLine()) {
                String[] linea = entrada.nextLine().split(" ");

                    if      (linea[0].equals("U")) { for (int i = 0; i < Integer.parseInt(linea[1]); i++) { movePosition ("U", pointsNine, hashtagsNine); } }
                    else if (linea[0].equals("D")) { for (int i = 0; i < Integer.parseInt(linea[1]); i++) { movePosition ("D", pointsNine, hashtagsNine); } }
                    else if (linea[0].equals("L")) { for (int i = 0; i < Integer.parseInt(linea[1]); i++) { movePosition ("L", pointsNine, hashtagsNine); } }
                    else if (linea[0].equals("R")) { for (int i = 0; i < Integer.parseInt(linea[1]); i++) { movePosition ("R", pointsNine, hashtagsNine); } }
            }
            System.out.println("Output: " + hashtagsNine.size());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void movePosition (String s, LinkedList<Point> l, Set<Object> set) {
        Point head = l.getFirst();
        switch (s) {
            case "U" -> head = new Point(head.x - 1, head.y);
            case "D" -> head = new Point(head.x + 1, head.y);
            case "L" -> head = new Point(head.x, head.y - 1);
            case "R" -> head = new Point(head.x, head.y + 1);
        }
        l.set(0, head);

        for(int j = 1; j < l.size(); j++) {
            head = l.get(j - 1);
            Point tail = l.get(j);
            int distFila = head.x - tail.x, distCol = head.y - tail.y;
            if (distFila < 0) { distFila *= (-1); }
            if (distCol < 0) { distCol *= (-1); }

            if (distFila > distCol) {
                if(head.x - tail.x > 1) { tail = new Point(tail.x + 1, head.y); } //down
                if(tail.x - head.x > 1) { tail = new Point(tail.x - 1, head.y); } //up
            } else if(distFila < distCol) {
                if(head.y - tail.y > 1) { tail = new Point(head.x, tail.y + 1); } //right
                if(tail.y - head.y > 1) { tail = new Point(head.x, tail.y - 1); } //left
            } else if(distFila > 1 && distCol > 1) {
                if(head.x - tail.x > 1) { tail = new Point(tail.x + 1, tail.y); } //down
                if(tail.x - head.x > 1) { tail = new Point(tail.x - 1, tail.y); } //up
                if(head.y - tail.y > 1) { tail = new Point(tail.x, tail.y + 1); } //right
                if(tail.y - head.y > 1) { tail = new Point(tail.x, tail.y - 1); } //left
            }
            l.set(j, tail);
            if (j == 9) { set.add(tail); }
        }
    }

}
