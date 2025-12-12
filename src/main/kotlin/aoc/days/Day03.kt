package aoc.days

import aoc.Day

class Day03 : Day(3) {
    override fun part1(): Any {
        var sumOfJoltages: Int = 0
        for (line in input) {
            val digits = line.map { it.digitToInt() }
            var bestJoltage: Int = 0
            for (i in digits.indices) {
                for (j in i + 1 until digits.size) {
                    val joltage = digits[i] * 10 + digits[j]
                    bestJoltage = maxOf(bestJoltage, joltage)
                }
            }
            sumOfJoltages += bestJoltage
        }
        return sumOfJoltages
    }

    override fun part2(): Any {
        return 0
    }
}
