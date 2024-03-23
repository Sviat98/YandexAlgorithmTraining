package org.example.season_5.block_4

fun arraySearch() {
    val elementsAmount = readln().toInt()

    val numbers = readln().split(' ').map { it.toInt() }.sorted()

    val answers = mutableListOf<Int>()


    val queries = readln().toInt()

    val begin = System.currentTimeMillis()



    repeat(queries) {
//        println(it)

        val (minNumber, maxNumber) = readln().split(' ').map { it.toInt() }

        var leftIndex = 0
        var rightIndex = numbers.size - 1

        var entriesExcluded = 0

        while (leftIndex < rightIndex) {
            val middleIndex = (leftIndex + rightIndex) / 2

            if (numbers[middleIndex] >= minNumber) {
                rightIndex = middleIndex
            } else {
                leftIndex = middleIndex + 1
                entriesExcluded++
            }
        }

//        leftIndex = 0
//        rightIndex = numbers.size - 1
//
//        while (leftIndex < rightIndex) {
//            val middleIndex = (leftIndex + rightIndex + 1) / 2
//
//            if (numbers[middleIndex] <= maxNumber) {
//                leftIndex = middleIndex
//            } else {
//                rightIndex = middleIndex - 1
//                entriesExcluded++
//            }
//        }

        val entries = numbers.size - entriesExcluded

        answers.add(entries)
    }

    println(answers.joinToString(" "))

    val end = System.currentTimeMillis()

    println("Execution time is ${end - begin} ms")

}