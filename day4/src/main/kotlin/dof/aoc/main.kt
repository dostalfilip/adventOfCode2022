package dof.aoc

import dof.aoc.util.AoCReader

/**
 * https://adventofcode.com/2022/day/4
 */
fun main() {

    fun part1(input: List<String>): Int {
        return input.map {line -> line.split(",", "-").map { it.toInt() } }.count {
            val (first, second, third, fourth) = it
            (first in third..fourth && second in third..fourth) || (third in first..second && fourth in first..second)
        }
    }

    fun part2(input: List<String>): Int {
        return input.map { line -> line.split(",", "-").map { elfSection -> elfSection.toInt() } }.count {
            val (first, second, third, fourth) = it
            (first in third..fourth || second in third..fourth)
                    || (third in first..second || fourth in first..second)
        }
    }

    val input = AoCReader.readFileByLines("elfSection.txt")
    println(part1(input))
    println(part2(input))
}