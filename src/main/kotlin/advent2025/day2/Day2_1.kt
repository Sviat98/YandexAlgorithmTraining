package org.example.advent2025.day2

import java.io.File
import java.io.FileReader

fun findInvalidIds_1() : Long {
    val pathToFile = "src/main/kotlin/advent2025/day2/input.txt"
    val file = File(pathToFile)
    val reader = FileReader(file)
    val input = reader.readLines().joinToString("")

    val ranges =input.split(',')

    val invalidIds = mutableSetOf<Long>()

    ranges.forEach { range ->
        val (rangeBegin, rangeEnd) = range.split('-').map { it.toLong() }

        for (numberInRange in rangeBegin..rangeEnd) {
            val numberString = numberInRange.toString()

            if (numberString.length % 2 == 0) {
                val numberStringHalf = numberString.length / 2
                val firstPart = numberString.take(numberStringHalf)
                val secondPart = numberString.drop(numberStringHalf)

                if (firstPart == secondPart){
                    invalidIds.add(numberInRange)
                }
            }
        }
    }

    println(invalidIds)

    val invalidIdsSum = invalidIds.sum()

    return invalidIdsSum
}