package Day11;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Day11_Silver {
    public static void main(String[] args) throws IOException {
        List<String> input;
        try (Stream<String> lines = Files.lines(Paths.get("aoc-22/aoc-22/src/Day11/example.txt"))) { input = lines.collect(Collectors.toList()); }
        for (String s : input) {
            System.out.println(s);
        }
    }
}
