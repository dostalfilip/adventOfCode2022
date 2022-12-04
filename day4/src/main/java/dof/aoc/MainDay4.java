package dof.aoc;

import dof.aoc.util.AoCReader;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * https://adventofcode.com/2022/day/4
 */
public class MainDay4 {

    public static void main(String[] args) {
        System.out.println("Hello AoC 2022 - day4");
        var testInput = checkInput();
        var fileInput = AoCReader.readFileByLines("elfSection.txt");

        //test
        System.out.println(getOverlapAllSectionPart1(testInput));

        //part1
        System.out.println(getOverlapAllSectionPart1(fileInput));

        //part2
        System.out.println( overlapAtAllPart2(fileInput));
    }

    //part2
    private static long overlapAtAllPart2(final List<String> input) {
        record Section(int leftBorder, int rightBorder) {}
        record ContainerSection(Section leftElf, Section rightElf) {}
        return input.stream().filter(section -> {
            var elfSections = Arrays.stream(section.split(","))
                                    .map(elfSection -> {
                                        String[] sections = elfSection.split("-");
                                        return new Section(Integer.parseInt(sections[0]), Integer.parseInt(sections[1]));
                                    })
                                    .toList();
            var bothSections = new ContainerSection(elfSections.get(0), elfSections.get(1));

            if((bothSections.leftElf.leftBorder >= bothSections.rightElf.leftBorder && bothSections.leftElf.leftBorder <= bothSections.rightElf.rightBorder) ||
                    (bothSections.leftElf.rightBorder >= bothSections.rightElf.leftBorder && bothSections.leftElf.rightBorder <= bothSections.rightElf.rightBorder))
                return true;

            if((bothSections.rightElf.leftBorder >= bothSections.leftElf.leftBorder && bothSections.rightElf.leftBorder <= bothSections.leftElf.rightBorder) ||
                    (bothSections.rightElf.rightBorder >= bothSections.leftElf.leftBorder && bothSections.rightElf.rightBorder <= bothSections.leftElf.rightBorder))
                return true;

            return false;
        }).count();
    }


    //part1
    private static long getOverlapAllSectionPart1(final List<String> input) {
        return input.stream().filter(section -> {
            var elfSections = Arrays.stream(section.split(",")).map(elfSection -> {
                String[] sections = elfSection.split("-");
                return new Pair<Integer, Integer>(Integer.parseInt(sections[0]), Integer.parseInt(sections[1]));
            }).toList();

            if (elfSections.get(0).component1() <= elfSections.get(1).component1()
                    && elfSections.get(0).component2() >= elfSections.get(1).component2()) return true;
            if (elfSections.get(0).component1() >= elfSections.get(1).component1()
                    && elfSections.get(0).component2() <= elfSections.get(1).component2()) return true;
            return false;
        }).count();
    }

    @NotNull
    private static List<String> checkInput() {
        return AoCReader.checkReader("""
                                             2-4,6-8
                                             2-3,4-5
                                             5-7,7-9
                                             2-8,3-7
                                             6-6,4-6
                                             2-6,4-8""");
    }
}