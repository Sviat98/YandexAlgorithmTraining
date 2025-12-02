package org.example.advent2025.day2

import java.io.File
import java.io.FileReader

fun findInvalidIds_2(): Long {
    val pathToFile = "src/main/kotlin/advent2025/day2/input.txt"
    val file = File(pathToFile)
    val reader = FileReader(file)
    val input = reader.readLines().joinToString("")

    val ranges = input.split(',')

    val invalidIds = mutableSetOf<Long>()

    ranges.forEach { range ->
        val (rangeBegin, rangeEnd) = range.split('-').map { it.toLong() }

        for (numberInRange in rangeBegin..rangeEnd) {
            val numberString = numberInRange.toString()

            val maxChunkSize = numberString.length / 2

            for (chunkSize in 1..maxChunkSize){
                if(numberString.length % chunkSize == 0){
                    val etalonChunk = numberString.take(chunkSize)

                    val restOfNumber = numberString.drop(chunkSize)

                    val numberOfChunksToCheck = restOfNumber.length / etalonChunk.length

                    for (i in 0..<numberOfChunksToCheck){
                        val chunkToCheckStartIndex = i*etalonChunk.length
                        val chunkToCheckEndIndex = (i+1)*etalonChunk.length

                        val chunkToCheck = restOfNumber.substring(chunkToCheckStartIndex,chunkToCheckEndIndex)

                        if (etalonChunk!=chunkToCheck){
                            break
                        }

                        if (i==numberOfChunksToCheck-1){
                            invalidIds.add(numberInRange)
                        }
                    }
                }

            }
        }
    }

    println(invalidIds)

    val invalidIdsSum = invalidIds.sum()

    return invalidIdsSum
}