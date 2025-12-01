package org.example.season_6.block_3

import java.util.LinkedList

fun minimumInWindow() {
    val (numbersAmount, windowSize) = readln().split(' ').map { it.toInt() }

    val numberPairs = readln().split(' ').mapIndexed { index, number -> Pair(index, number.toInt()) }

    val numbersQueue = LinkedList<Pair<Int, Int>>()

    var maxRightIndex = windowSize - 1

    numberPairs.forEachIndexed { index, pair ->

        numbersQueue.addLast(pair)

        val firstElement = numbersQueue.peekFirst()

        if (maxRightIndex-windowSize==firstElement.first) {
            numbersQueue.removeFirst()
        }

        if (index >= windowSize) {
            println(numbersQueue.peekFirst().second)
        }

        if (maxRightIndex != numberPairs.size - 1) {
            maxRightIndex++
        }
    }

    println(numbersQueue)
}