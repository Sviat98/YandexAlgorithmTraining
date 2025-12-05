package org.example.advent2025.day5

import java.io.File
import java.io.FileReader

fun findFreshIngredients_2(): Long {
    val pathToFile = "src/main/kotlin/advent2025/day5/input.txt"
    val file = File(pathToFile)
    val reader = FileReader(file)
    val lines = reader.readLines().toSet()

    val freshIngredientsRanges = mutableSetOf<Pair<Long, Long>>()

    var freshIngredientsCounter = 0L

    lines.forEach { line ->
        val (beginRange, endRange) = line.split('-').map { it.toLong() }

        freshIngredientsRanges.add(Pair(beginRange, endRange))
    }

    var currentFreshId = 0L

    freshIngredientsRanges.sortedWith(
        compareBy<Pair<Long, Long>> { it.first }
        .thenBy { it.second }
    ).forEach { (beginRange, endRange) ->
        val startId = (currentFreshId + 1L).coerceAtLeast(beginRange)

        freshIngredientsCounter += (endRange - startId + 1).coerceAtLeast(0L)

        currentFreshId = endRange.coerceAtLeast(currentFreshId)
    }

    return freshIngredientsCounter
}