package org.example.season_5.block_2

fun noMoreNoLess() {
    val numOfTestData = readln().toInt()

    repeat(numOfTestData) {
        val testDataSize = readln().toInt()

        val testDataList = readln().split(' ').map { it.toInt() }

        val sublistSizes = mutableListOf<Int>() // размеры подмножеств

        var currentSublistLength = 0

        var possibleSublistLength = 0


        testDataList.forEachIndexed { index, item ->

            if (item < possibleSublistLength || possibleSublistLength == 0) {
                possibleSublistLength = item
            }

//            subListLengthToAdd = currentSublistLength

            currentSublistLength++

            if (currentSublistLength == possibleSublistLength || item < currentSublistLength || index == testDataList.size - 1) {

                val subListLengthToAdd =
                    if (item < currentSublistLength) currentSublistLength - 1 else currentSublistLength
                sublistSizes.add(subListLengthToAdd)
                possibleSublistLength = 0
                currentSublistLength = 0
            }


        }

        println(sublistSizes.size)
        println(sublistSizes.joinToString(" "))

    }
}