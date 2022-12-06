package dof.aoc;

import dof.aoc.util.AoCReader;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://adventofcode.com/2022/day/6
 */
public class Main {

//    Here are a few more examples:
//
//    bvwbjplbgvbhsrlpgdmjqwftvncz: first marker after character 5
//    nppdvjthqldpwncqszvftbrmjlhg: first marker after character 6
//    nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg: first marker after character 10
//    zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw: first marker after character 11

    public static void main(String[] args) {
        System.out.println("Hello AoC Day 6 ");

        var text = AoCReader.readFileAsText("code.txt");
        var testText = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";

        findMarker(text, 4);
        findMarker(text, 14);
    }

    private static void findMarker(final String text, int numberOfUniqueChar) {
        var dequeue = new ArrayDeque<Character>();
        var atomicInt = new AtomicInteger();
        CharacterIterator it = new StringCharacterIterator(text);
        while(it.current() != CharacterIterator.DONE){
            while(dequeue.contains(it.current())) dequeue.pop();

            dequeue.add(it.current());
            atomicInt.incrementAndGet();

            if(dequeue.size() == numberOfUniqueChar) break;
            it.next();
        }

        System.out.println(atomicInt.get());
    }
}