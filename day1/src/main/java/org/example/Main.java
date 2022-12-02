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
        var listOfCalories = Arrays.stream(Files.readString(Paths.get(filePath)).split("\\n\\n"))
                          .map(groupOfNumbers -> Arrays.stream(groupOfNumbers.split("\\n"))
                                             .mapToInt(num -> Integer.parseInt(num))
                                             .sum())
                          .sorted(Comparator.reverseOrder()).toList();

        System.out.println("Most Calories");
        System.out.println(listOfCalories.get(0));

        System.out.println("Sum Top 3 Calorie Group");
        System.out.println(listOfCalories.get(0) + listOfCalories.get(1) + listOfCalories.get(2));

    }
}