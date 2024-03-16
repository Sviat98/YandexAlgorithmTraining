package org.example.season_5.block_3

import kotlin.math.max

fun deleteNumbers() {
    val numbersAmount = readln().toInt()

    val numbers = readln().split(' ').map { it.toInt() }

    val begin = System.currentTimeMillis()

    val numbersMap = numbers.groupingBy { it }.eachCount()

    var numbersToDelete = 200001

    numbers.toSet().forEach { number ->

        val numbersOfCurrent = numbersMap[number] ?: 0

        val numbersPlusOne = numbersMap[number + 1] ?: 0

        val numbersMinusOne = numbersMap[number - 1] ?: 0

        val currentNumbersToDelete = numbersAmount- numbersOfCurrent - max(numbersMinusOne, numbersPlusOne)

        if(currentNumbersToDelete<numbersToDelete){
            numbersToDelete = currentNumbersToDelete
        }
    }

    println(numbersToDelete)

    val end = System.currentTimeMillis()

    println("Execution time is ${end - begin} ms")
}