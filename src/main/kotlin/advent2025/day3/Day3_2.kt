package org.example.advent2025.day3

import java.io.File
import java.io.FileReader

fun findJoltage_2(): Long {
    val pathToFile = "src/main/kotlin/advent2025/day3/input.txt"
    val file = File(pathToFile)
    val reader = FileReader(file)
    val lines = reader.readLines()

    var joltageSum = 0L

    lines.forEach { line ->
        val joltage = findMaxJoltage(bank = line, windowSize = 12, currentJoltage = 0L)

        joltageSum += joltage
    }

    return joltageSum
}

fun findMaxJoltage(
    bank: String,
    windowSize: Int,
    currentJoltage: Long,
): Long {
    val bankWindow = bank.dropLast(windowSize - 1)

    val maxValueInWindow = bankWindow.map { it.toString().toLong() }.max()

    val newJoltage = currentJoltage * 10 + maxValueInWindow

    if (windowSize == 1) {
        return newJoltage
    }

    val newJoltageIndex = bank.indexOf(maxValueInWindow.toString())

    return findMaxJoltage(
        bank = bank.drop(newJoltageIndex + 1),
        windowSize = windowSize - 1,
        currentJoltage = newJoltage
    )
}