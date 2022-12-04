package org.example;

import dof.aoc.util.AoCReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 * https://adventofcode.com/2022/day/2
 */
public class Main {

    final static Logger logger = Logger.getLogger(Main.class.getName());
    static int totalScore = 0;
    static int totalScore_quest2 = 0;


    //  Opponent:  A for Rock, B for Paper, and C for Scissors.
    //  Me: X for Rock, Y for Paper, and Z for Scissors.
    public static void main(String[] args) {
        System.out.println("Hello AOC 2022 - Day 2");


        try (BufferedReader br = new BufferedReader(new InputStreamReader(AoCReader.readFileAsStream("gameInput.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                executeRound(line);
                executeRound_quest2(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        logger.info("First Score is " + totalScore);
        logger.info("Second Score is " + totalScore_quest2);
    }

    static void executeRound(String line){
       if(line.matches("(A Y)|(B Z)|(C X)")){
           totalScore += 6;
       }else if(line.matches("(A X)|(B Y)|(C Z)")){
           totalScore += 3;
       }
       if(line.charAt(2) == 'X') totalScore += 1;
       if(line.charAt(2) == 'Y') totalScore += 2;
       if(line.charAt(2) == 'Z') totalScore += 3;
    }

    //  Opponent:  A for Rock, B for Paper, and C for Scissors.
    //  Me: X for Rock, Y for Paper, and Z for Scissors.
    //(1 for Rock, 2 for Paper, and 3 for Scissors)
    static void executeRound_quest2(String line){
        if (line.matches("(B X)|(A Y)|(C Z)")) { //ROCK
            totalScore_quest2 += 1;
        } else if (line.matches("(C X)|(B Y)|(A Z)")) { //PAPER
            totalScore_quest2 += 2;
        } else if (line.matches("(A X)|(C Y)|(B Z)")) { //Sciccors
            totalScore_quest2 += 3;
        }

        if(line.charAt(2) == 'X') totalScore_quest2 += 0;
        if(line.charAt(2) == 'Y') totalScore_quest2 += 3;
        if(line.charAt(2) == 'Z') totalScore_quest2 += 6;
    }

//    Second quest
//    X means you need to lose,
//    Y means you need to end the round in a draw,
//    Z means you need to win. Good luck!"



}