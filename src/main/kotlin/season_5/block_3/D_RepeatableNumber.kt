package org.example.season_5.block_3

fun repeatableNumber() {
    val (numbersAmount, maxRepeatDistance) = readln().split(' ').map { it.toInt() }

    val numbers = readln().trim().split(' ').map { it.toInt() }

    val begin = System.currentTimeMillis()

    var answer = "NO"

    val numbersMap = mutableMapOf<Int,MutableSet<Int>>()

    numbers.forEachIndexed { index, number ->

        var indexList = numbersMap[number]

        if(indexList==null){
            indexList = mutableSetOf()
            numbersMap[number] = indexList
        }

        indexList.add(index)
    }

    numbersMap.forEach { entry ->
        val indexList = entry.value

        var minDiff = 100000

        for (i in 0 until indexList.size - 1) {
            val possibleMin = indexList.elementAt(i+1) - indexList.elementAt(i)

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