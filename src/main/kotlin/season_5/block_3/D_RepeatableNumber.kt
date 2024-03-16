package org.example.season_5.block_3

fun repeatableNumber() {
    val (numbersAmount, maxRepeatDistance) = readln().split(' ').map { it.toInt() }

    val numbers = readln().trim().split(' ').map { it.toInt() }

    val begin = System.currentTimeMillis()

    var answer = "NO"

    val repeatedNumbersMap = numbers.groupingBy { it }.eachCount().filterValues { it > 1 }

    println(repeatedNumbersMap)

    val timeBeforeHandlingMap = System.currentTimeMillis()

    println(repeatedNumbersMap)

    println("Time Before Handling Map is ${timeBeforeHandlingMap-begin} ms")

    repeatedNumbersMap.forEach { entry ->
        val indexList = numbers.mapIndexed { index, i -> Pair(i, index) }.filter { it.first == entry.key }.map { it.second }.sorted()

        var minDiff = 10000

        for (i in 0 until indexList.size - 1) {
            val possibleMin = indexList[i + 1] - indexList[i]

            if (possibleMin < minDiff) {
                minDiff = possibleMin
            }
        }

        if (minDiff <= maxRepeatDistance) {
            answer = "YES"
            return@forEach
        }
    }

    println(answer)

    val end = System.currentTimeMillis()

    println("Execution time is ${end - begin} ms")
}