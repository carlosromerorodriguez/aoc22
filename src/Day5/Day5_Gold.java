package Day5;

import java.io.*;
import java.util.*;

public class Day5_Gold {

    public static void main(String[] args) {
        //Array de Deques
        LinkedList<Deque> deques = new LinkedList<>();
        File f = new File("aoc-22/src/Day5/output.txt");
        try {
            Scanner entrada = new Scanner(f);
            Deque<Object> deque1 = new ArrayDeque<>();
            Deque<Object> deque2 = new ArrayDeque<>();
            Deque<Object> deque3 = new ArrayDeque<>();
            Deque<Object> deque4 = new ArrayDeque<>();
            Deque<Object> deque5 = new ArrayDeque<>();
            Deque<Object> deque6 = new ArrayDeque<>();
            Deque<Object> deque7 = new ArrayDeque<>();
            Deque<Object> deque8 = new ArrayDeque<>();
            Deque<Object> deque9 = new ArrayDeque<>();

            while (entrada.hasNextLine()) {
                String leer = entrada.nextLine();
                if (leer.charAt(1) == '1') {
                    entrada.nextLine();
                    entrada.nextLine();
                } else {
                    if (leer.charAt(0) != 'm') {
                        leer = leer + "---------------------------------------------------------------";
                        if (leer.charAt(1) >= 'A' && leer.charAt(1) <= 'Z') {
                            deque1.addFirst(leer.charAt(1));
                        }
                        if (leer.charAt(5) >= 'A' && leer.charAt(5) <= 'Z') {
                            deque2.addFirst(leer.charAt(5));
                        }
                        if (leer.charAt(9) >= 'A' && leer.charAt(9) <= 'Z') {
                            deque3.addFirst(leer.charAt(9));
                        }
                        if (leer.charAt(13) >= 'A' && leer.charAt(13) <= 'Z') {
                            deque4.addFirst(leer.charAt(13));
                        }
                        if (leer.charAt(17) >= 'A' && leer.charAt(17) <= 'Z') {
                            deque5.addFirst(leer.charAt(17));
                        }
                        if (leer.charAt(21) >= 'A' && leer.charAt(21) <= 'Z') {
                            deque6.addFirst(leer.charAt(21));
                        }
                        if (leer.charAt(25) >= 'A' && leer.charAt(25) <= 'Z') {
                            deque7.addFirst(leer.charAt(25));
                        }
                        if (leer.charAt(29) >= 'A' && leer.charAt(29) <= 'Z') {
                            deque8.addFirst(leer.charAt(29));
                        }
                        if (leer.charAt(33) >= 'A' && leer.charAt(33) <= 'Z') {
                            deque9.addFirst(leer.charAt(33));
                        }
                    }
                }
            }
            deques.add(deque1); deques.add(deque2); deques.add(deque3);
            deques.add(deque4); deques.add(deque5); deques.add(deque6);
            deques.add(deque7); deques.add(deque8); deques.add(deque9);

            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String leer = scanner.nextLine();
                leer = leer + "-";
                if (leer.charAt(0) == 'm') {
                    String aux = String.valueOf(Integer.parseInt(leer.replaceAll("[\\D]", "")));
                    String[] digits = aux.split("(?<=.)");
                    int move = 0, from = 0, to = 0;
                    if (digits.length == 4) {
                        move = Integer.parseInt(digits[0])*10 + Integer.parseInt(digits[1]);
                        from = Integer.parseInt(digits[2])-1;
                        to = Integer.parseInt(digits[3])-1;
                    } else {
                        move = Integer.parseInt(digits[0]);
                        from = Integer.parseInt(digits[1])-1;
                        to = Integer.parseInt(digits[2])-1;
                    }
                    Deque aux1 = new ArrayDeque<>();
                    for (int i = 0; i < move; i++) {
                        Deque fr = (Deque) deques.get(from);

                        if (!fr.isEmpty()) { aux1.addFirst(fr.getLast()); fr.removeLast(); }
                    }
                    Deque t = (Deque) deques.get(to);
                    for (int i = 0; i < move; i++) {
                        t.add(aux1.getFirst());
                        aux1.removeFirst();
                    }
                }
            }
            for (int i = 0; i < deques.size(); i++) {
                Deque aux1 = (Deque) deques.get(i);
                System.out.print(aux1.getLast());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
