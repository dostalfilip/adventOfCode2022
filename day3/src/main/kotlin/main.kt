import dof.aoc.util.AoCReader

/**
 * https://adventofcode.com/2022/day/3
 */
fun main(){
    val input = AoCReader.readFileByLines("input.txt")
    println(part1(input))
    println(part2(input))
}

fun part1(input: List<String>) =
    input
        .map { it.chunked(it.length / 2) { str -> str.toSet() } }
        .flatMap { it.reduce { acc, next -> acc.intersect(next) } }
        .sumOf { value(it) }


fun part2(input: List<String>) =
    input
        .chunked(3) { it.map { str -> str.toSet() } }
        .flatMap { it.reduce { acc, next -> acc.intersect(next) } }
        .sumOf { value(it) }


fun value(it: Char) = when (it) {
    in 'a'..'z' -> it - 'a' + 1
    in 'A'..'Z' -> it - 'A' + 27
    else -> throw IllegalArgumentException("$it must be in a..z or A..Z")
}