package aoc.days

import aoc.Day

class Day02 : Day(2) {
    override fun part1(): Any {
        val invalidIds = mutableListOf<Long>()
        val ranges = input[0].split(",").filter { it.isNotBlank() }

        for (r in ranges) {
            val (startStr, endStr) = r.split("-")

            for (id in startStr.toLong()..endStr.toLong()) {
                if (isRepeatedTwice(id.toString())) invalidIds.add(id)
            }
        }
        return "Sum of invalid IDs: ${invalidIds.sum()}"
    }

    override fun part2(): Any {
        return 0
    }

    fun isRepeatedTwice(id: String): Boolean =
        id.length % 2 == 0 && id.take(id.length / 2) == id.drop(id.length / 2)
}
