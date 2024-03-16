package org.example.season_5.block_3

fun twoOutOfThree() {
    val numbersMap = mutableMapOf<Int, Int>()

    repeat(3) {
        val numbersAmount = readln().toInt()

        val numbersSet = readln().split(' ').map { it.toInt() }.toSet()

        numbersSet.forEach { number ->
            val numbersAmount = numbersMap[number] ?: 0

            numbersMap[number] = numbersAmount + 1
        }
    }

    val answerNumbers = numbersMap.filterValues { it > 1 }.map { it.key }.sorted().joinToString(" ")

    println(answerNumbers)
}