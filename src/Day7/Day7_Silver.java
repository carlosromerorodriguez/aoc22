package Day7;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Day7_Silver {
    public static void main(String[] args) {
        File f = new File("src/Day7/output.txt");
        try {
            Scanner entrada = new Scanner(f);
            int ultimo_dir_pos = 0, suma_dir = 0, res = 0;
            String dest = "", actual = "";
            Deque<String> deque = new ArrayDeque<>();
            HashMap<String, Integer> dirs = new HashMap<>();
            boolean flag = false;
            DecimalFormat decimalFormat = new DecimalFormat("###,###.##");

            while (entrada.hasNextLine()) {
                String leer = entrada.nextLine();
                if (leer.charAt(0) == '$') {
                    if (flag) { dirs.put(dest, suma_dir); suma_dir = 0; flag = false; }
                    if (leer.contains("cd")) {
                        if (leer.contains("cd ..")) {
                            int distance = dest.length()-actual.length();
                            dest = dest.substring(0, distance);
                            int dir_dest = dirs.get(dest.substring(0, ultimo_dir_pos) + actual);
                            deque.pop(); actual = deque.peek();
                            assert actual != null; ultimo_dir_pos = dest.length() - actual.length();
                            dirs.put(dest.substring(0, ultimo_dir_pos) + actual, dirs.get(dest.substring(0, ultimo_dir_pos) + actual) + dir_dest);
                        } else {
                            ultimo_dir_pos = dest.length();
                            actual = leer.substring(5);
                            dest += actual;
                            deque.push(actual);
                        }
                    } else if (leer.contains("ls")) { flag = true; }
                } else {
                    if (!leer.contains("dir")) {
                        String aux = String.valueOf(Integer.parseInt(leer.replaceAll("[\\D]", "")));
                        suma_dir += Integer.parseInt(aux);
                    }
                }
            }
            dirs.put(actual, suma_dir); actual = deque.pop();

            while (!deque.isEmpty() && !dirs.isEmpty()) {
                Integer num = dirs.get(actual);
                actual = deque.pop();
                if (dirs.get(actual) != null) { int next_pos = dirs.get(actual); if (num != null) { next_pos += num; } dirs.put(actual, next_pos); }
            }
            for (HashMap.Entry<String, Integer> entry : dirs.entrySet()) { if (entry.getValue() <= 100000) { res += entry.getValue(); } }

            System.out.println("Output: "+ decimalFormat.format(res));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
