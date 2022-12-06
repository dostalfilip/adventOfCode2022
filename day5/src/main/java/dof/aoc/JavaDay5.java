package dof.aoc;

import dof.aoc.util.AoCReader;
import org.jetbrains.annotations.NotNull;

import java.util.*;


/**
 *  https://adventofcode.com/2022/day/5
 */
public class JavaDay5 {
    public static void main(String[] args) {
        System.out.println("Hello AoC - Day 5 - Java!");
        var testInput = checkInput();
        var fileInput = AoCReader.readFileByLines("craneMovements.txt");

        testInput.forEach(System.out::println);

        testAssigment(testInput);
        part1(fileInput);
        part2(fileInput);
    }

    private static void part2(final List<String> testInput) {
        LinkedList<Character>[] arrayStack = parseData(testInput);

        testInput.stream().skip(10).forEach(line -> {
            if (line.isEmpty()) return;
            var reducedLine = line.replaceAll("[a-z]", "");

            var reducedLineToNumber = reducedLine.split("^[0-9]");

            var numbers = reducedLineToNumber[0].split(" ");

            record MoveFromTo(Integer move, LinkedList<Character> from, LinkedList<Character> to) {}
            var operation = new MoveFromTo(Integer.parseInt(numbers[1]),
                                           arrayStack[Integer.parseInt(numbers[3]) - 1],
                                           arrayStack[Integer.parseInt(numbers[5]) - 1]);

            var list = new ArrayList();
            for (int move = 1; move <= operation.move; move++) {
                list.add(operation.from.poll());

            }
            for (int position = list.size() - 1; position >= 0; position--) {
                operation.to.addFirst((Character) list.get(position));
            }
        });

        System.out.println(arrayStack[0].peek().toString() + arrayStack[1].peek().toString() + arrayStack[2].peek().toString() + arrayStack[3].peek().toString() + arrayStack[4].peek() +
                                   arrayStack[5].peek().toString() + arrayStack[6].peek().toString() + arrayStack[7].peek().toString() + arrayStack[8].peek().toString());
    }


    private static void part1(final List<String> testInput) {
        LinkedList<Character>[] arrayStack = parseData(testInput);

        testInput.stream().skip(10).forEach(line -> {
            if(line.isEmpty()) return;
            var reducedLine = line.replaceAll("[a-z]", "");

            var reducedLineToNumber = reducedLine.split("^[0-9]");

            var numbers = reducedLineToNumber[0].split(" ");


            record MoveFromTo(Integer move, LinkedList<Character> from, LinkedList<Character> to){}
            var operation = new MoveFromTo( Integer.parseInt(numbers[1]),
                                            arrayStack[Integer.parseInt(numbers[3]) -1],
                                            arrayStack[Integer.parseInt(numbers[5]) -1]);

            for(int move = 1; move <= operation.move; move++){
                operation.to.addFirst(operation.from.poll());
            }
        });

        System.out.println(arrayStack[0].peek().toString() + arrayStack[1].peek().toString() + arrayStack[2].peek().toString() + arrayStack[3].peek().toString() + arrayStack[4].peek() +
                arrayStack[5].peek().toString() + arrayStack[6].peek().toString() + arrayStack[7].peek().toString() + arrayStack[8].peek().toString());
    }

    private static void testAssigment(final List<String> testInput) {
        Stack<Character>[] arrayStack = new Stack[3];
        arrayStack[0] = new Stack<>();
        arrayStack[1] = new Stack<>();
        arrayStack[2] = new Stack<>();
        testInput.stream().limit(3).sorted(Comparator.reverseOrder()).forEach(line -> {
           char one = line.charAt(1);
           char two = line.charAt(5);
           char three = line.charAt(9);
           if(one != ' ') arrayStack[0].add(one);
           if(two != ' ') arrayStack[1].add(two);
           if(three != ' ') arrayStack[2].add(three);
        });

        testInput.stream().skip(5).forEach(line -> {
            if(line.isEmpty()) return;
            var reducedLine = line.replaceAll("[a-z]", "");

            var reducedLineToNumber = reducedLine.split("^[0-9]");

            var numbers = reducedLineToNumber[0].split(" ");


            record MoveFromTo(Integer move, Stack<Character> from, Stack<Character> to){}
            var operation = new MoveFromTo( Integer.parseInt(numbers[1]),
                                            arrayStack[Integer.parseInt(numbers[3]) -1], arrayStack[Integer.parseInt(numbers[5]) -1]);

            for(int move = 1; move <= operation.move; move++){
                operation.to.push(operation.from.pop());
            }
        });

        System.out.println(arrayStack[0].peek().toString() + arrayStack[1].peek().toString() + arrayStack[2].peek().toString());
    }


    @NotNull
    private static List<String> checkInput() {
        return AoCReader.checkReader("""
                                                 [D]    l
                                             [N] [C]    l
                                             [Z] [M] [P]
                                              1   2   3
                                                                                          
                                             move 1 from 2 to 1
                                             move 3 from 1 to 3
                                             move 2 from 2 to 1
                                             move 1 from 1 to 2
                                             """);
    }
    @NotNull
    private static LinkedList<Character>[] parseData(@NotNull final List<String> testInput) {
        LinkedList<Character>[] arrayStack = new LinkedList[9];
        for(int pos = 0; pos < arrayStack.length; pos++){
            arrayStack[pos] = new LinkedList<>();
        }

        for (int i = 0; i <= 7; i++) {

            String line = testInput.get(i);
            char one = line.charAt(1);
            char two = line.charAt(5);
            char three = line.charAt(9);
            char four = line.charAt(13);
            char five = line.charAt(17);
            char six = line.charAt(21);
            char seven = line.charAt(25);
            char eight = line.charAt(29);
            char nine = line.charAt(33);


            if (one != ' ') arrayStack[0].add(one);
            if (two != ' ') arrayStack[1].add(two);
            if (three != ' ') arrayStack[2].add(three);
            if (four != ' ') arrayStack[3].add(four);
            if (five != ' ') arrayStack[4].add(five);
            if (six != ' ') arrayStack[5].add(six);
            if (seven != ' ') arrayStack[6].add(seven);
            if (eight != ' ') arrayStack[7].add(eight);
            if (nine != ' ') arrayStack[8].add(nine);
        }
        return arrayStack;
    }
}
