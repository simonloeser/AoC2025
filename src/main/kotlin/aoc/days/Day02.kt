package aoc.days

import aoc.Day

class Day02 : Day(2) {
    override fun part1(): Any {
        val invalidIds = mutableListOf<Long>()
        val ranges = input[0].split(",").mapNotNull { it.takeIf { it.isNotBlank() } }

        for (r in ranges) {
            val (startStr, endStr) = r.split("-")

            for (id in startStr.toLong()..endStr.toLong()) {
                if (isRepeatedTwice(id.toString())) invalidIds.add(id)
            }
        }
        return "Sum of invalid IDs: ${invalidIds.sum()}"
    }

    override fun part2(): Any {
        val invalidIds = mutableListOf<Long>()
        val ranges = input[0].split(",").mapNotNull { it.takeIf { it.isNotBlank() } }

        for (r in ranges) {
            val (startStr, endStr) = r.split("-")

            for (id in startStr.toLong()..endStr.toLong()) {
                if (isRepeated(id.toString())) invalidIds.add(id)
            }
        }
        return "Sum of invalid IDs: ${invalidIds.sum()}"
    }

    fun isRepeatedTwice(id: String): Boolean =
        id.length % 2 == 0 && id.take(id.length / 2) == id.drop(id.length / 2)

    private fun isRepeated(text: String): Boolean {
        val n = text.length
        if (n < 2) return false

        for (len in 1..n / 2) {

            if (n % len != 0) continue

            var isPattern = true
            for (i in len until n) {
                if (text[i] != text[i % len]) {
                    isPattern = false
                    break
                }
            }
            if (isPattern) return true
        }
        return false
    }

    /*fun isRepeated(id: String): Boolean {
        // Bro, der long aus der range kann niemals null sein, aber ohne print o.ä. crasht die Scheiße einfach
        // Liegt an take und repeat alles klar, danke JVM
        print("${id} ")
        if (id.length < 2) return false

        for (len in 1..id.length / 2) {
            if (id.length % len != 0) continue

            val repeatCount = id.length / len

            if (repeatCount < 2) continue
            if (id.take(len).repeat(repeatCount) == id) return true
        }
        return false
    }*/
}
