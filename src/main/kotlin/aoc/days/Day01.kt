package aoc.days

import aoc.Day

class Day01 : Day(1) {
    override fun part1(): Any {
        var dial = 50
        var dialPointedAtZero = 0

        for (instruction in input) {
            val n = instruction.drop(1).toInt()
            dial = if (instruction.startsWith("L")) {
                (dial - n).mod(100)
            } else {
                (dial + n).mod(100)
            }
            dialPointedAtZero += if (dial == 0) 1 else 0
        }
        return "day 1 part 1: $dialPointedAtZero"
    }

    override fun part2(): Any {
        return "day 1 part 2 test"
    }
}
