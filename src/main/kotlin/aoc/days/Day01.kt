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
            if (dial == 0) dialPointedAtZero++
        }
        return dialPointedAtZero
    }

    override fun part2(): Any {
        var dial = 50
        var crossesZero = 0

        for (instruction in input) {
            val n = instruction.drop(1).toInt()
            val old = dial

            if (instruction.startsWith("L")) {
                if (n > old) crossesZero++
                dial = (old - n).mod(100)
            } else {
                if (old + n >= 100) crossesZero++
                dial = (old + n).mod(100)
            }
            if (dial == 0) crossesZero++
        }
        return crossesZero
    }
}
