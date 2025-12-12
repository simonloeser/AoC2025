package aoc.days

import aoc.Day
import java.math.BigInteger

class Day03 : Day(3) {
    override fun part1(): Any {
        var sumOfJoltages = 0
        for (line in input) {
            val digits = line.map { it.digitToInt() }
            var bestJoltage = 0
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
        var sumOfJoltages = BigInteger.ZERO

        for (line in input) {
            val n = 12
            val digits = line.map { it.digitToInt() }
            val stack = mutableListOf<Int>()

            for ((i, d) in digits.withIndex()) {
                while (stack.isNotEmpty() && stack.last() < d && stack.size + digits.size - i - 1 >= n) {
                    stack.removeAt(stack.size - 1)
                }
                if (stack.size < n) {
                    stack.add(d)
                }
            }

            val largest = BigInteger(stack.joinToString(""))
            sumOfJoltages += largest
        }
        return sumOfJoltages
    }
}
