package dof.aoc

import dof.aoc.util.AoCReader
import dof.aoc.util.AoCReader.Companion.readFileByLines

fun main() {
    println("Hello AoC - Day 5 - Kotlin!")
    val testInput: List<String> = checkInput()
    val fileInput = readFileByLines("craneMovements.txt")


    val input = fileInput

    val numberOfStacks =
        input.dropWhile { it.contains("[") }.first().split(" ").filter { it.isNotBlank() }.maxOf { it.toInt() }

    val stacks = List(numberOfStacks) { ArrayDeque<Char>() }
    val steps = mutableListOf<Step>()

    input.filter { it.contains("[") }
        .map { line ->
            line
                .mapIndexed { index, char -> if (char.isLetter()) stacks[index / 4].addLast(line[index]) }
        }

    input.filter { it.contains("move") }.map { steps.add(Step.of(it)) }

    println(partOne(stacks.map { ArrayDeque(it) }.toList(), steps))
    println(partTwo(stacks, steps))

}


private fun checkInput(): List<String> {
    return AoCReader.checkReader(
        """
    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
                                             """.trimIndent()
    )
}


data class Step(val quantity: Int, val source: Int, val target: Int) {

    companion object {
        fun of(line: String): Step {
            return line.split(" ").filterIndexed{ index, _ -> index % 2 == 1}.map { it.toInt() }.let { Step(it[0], it[1]-1, it[2]-1) }
        }
    }
}

private fun partOne(stacks: List<ArrayDeque<Char>>, steps: List<Step>): String {
    steps.map {step -> repeat(step.quantity) { stacks[step.target].addFirst(stacks[step.source].removeFirst()) } }
    return stacks.map { it.first() }.joinToString(separator = "")
}

private fun partTwo(stacks: List<ArrayDeque<Char>>, steps: List<Step>): String {
    steps.map {step ->
        stacks[step.source].subList(0, step.quantity).asReversed()
            .map { stacks[step.target].addFirst(it) }
            .map { stacks[step.source].removeFirst() }
    }
    return stacks.map { it.first() }.joinToString(separator = "")
}

