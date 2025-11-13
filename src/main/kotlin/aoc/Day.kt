package aoc

import java.io.File

abstract class Day(val dayNumber: Int) {
    protected val input: List<String> by lazy {
        readInput(dayNumber)
    }

    abstract fun part1(): Any
    abstract fun part2(): Any

    private fun readInput(dayNumber: Int): List<String> {
        val path = "src/main/resources/inputs/day%02d.txt".format(dayNumber)
        return File(path).readLines()
    }
}
