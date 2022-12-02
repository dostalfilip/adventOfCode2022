package org.example;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        String filePath = Objects.requireNonNull(Main.class.getClassLoader().getResource("data.txt")).getPath();

        System.out.println("Most Calories");
        System.out.println(groupedCaloriesStream(filePath).limit(1).findFirst().get());

        System.out.println("Sum Top 3 Calorie Group");
        System.out.println(groupedCaloriesStream(filePath).limit(3).collect(Collectors.summingInt(count -> count)));
    }

    @NotNull
    private static Stream<Integer> groupedCaloriesStream(final String filePath) throws IOException {
        return Arrays.stream(Files.readString(Paths.get(filePath)).split("\\n\\n"))
                     .map(groupOfNumbers -> Arrays.stream(groupOfNumbers.split("\\n"))
                                                  .mapToInt(num -> Integer.parseInt(num))
                                                  .sum())
                     .sorted(Comparator.reverseOrder());
    }
}