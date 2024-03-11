package org.example.season_5.block_2

fun noMoreNoLess() {
    val numOfTestData = readln().toInt()

    repeat(numOfTestData) {
        val testDataSize = readln().toInt()

        val testDataList = readln().split(' ').map { it.toInt() }

        val sublistSizes = mutableListOf<Int>() // размеры подмножеств

        var currentSublistLength = 0

        var possibleSublistLength = testDataList[0]

        testDataList.forEachIndexed { index, item ->

            if (item < possibleSublistLength) {
                possibleSublistLength = item
            }

            currentSublistLength++

            when {
                (index != testDataList.size - 1) -> {
                    val nextItem = testDataList[index + 1]

                    if (nextItem <= currentSublistLength || currentSublistLength == possibleSublistLength) {
                        sublistSizes.add(currentSublistLength)
                        possibleSublistLength = nextItem
                        currentSublistLength = 0
                    }
                }
                else -> {
                    sublistSizes.add(currentSublistLength)
                }
            }
        }

        println(sublistSizes.size)
        println(sublistSizes.joinToString(" "))
    }
}