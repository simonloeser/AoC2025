package aoc

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Missing day input (example: 1 for day01)")
        return
    }

    val dayNumber = args[0].toIntOrNull() ?: run {
        println("No valid day given: ${args[0]}. Valid range: 1-24")
        return
    }

    val className = "aoc.days.Day%02d".format(dayNumber)
    val day: Day = try {
        val clazz = Class.forName(className).kotlin
        val constructor = clazz.constructors.first()
        constructor.call() as Day
    } catch (_: Exception) {
        println("Day $dayNumber is not yet implemented")
        return
    }

    println("Day ${day.dayNumber} part 1: ${day.part1()}")
    println("Day ${day.dayNumber} part 2: ${day.part2()}")
}
