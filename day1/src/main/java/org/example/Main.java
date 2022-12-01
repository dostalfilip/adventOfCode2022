package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {

        String filePath = Objects.requireNonNull(Main.class.getClassLoader().getResource("data.txt")).getPath();
        var array = Arrays.stream(Files.readString(Paths.get(filePath)).split("\\n\\n"))
                          .map(groupOfNumbers -> Arrays.stream(groupOfNumbers.split("\\n"))
                                             .mapToInt(num -> Integer.parseInt(num))
                                             .sum())
                          .sorted(Comparator.reverseOrder()).toList();

        System.out.println("Most Calories");
        System.out.println(array.get(0));

        System.out.println("Top 3 sum Calories");
        System.out.println(array.get(0) + array.get(1) + array.get(2));

    }
}