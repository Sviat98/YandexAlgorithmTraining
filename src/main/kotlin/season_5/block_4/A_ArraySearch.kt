package org.example.season_5.block_4

fun arraySearch() {
    val elementsAmount = readln().toInt()

    val numbers = readln().split(' ').map { it.toInt() }.sorted()

    val answers = mutableListOf<Int>()

    val queries = readln().toInt()

    val begin = System.currentTimeMillis()

    repeat(queries) {

        val (minNumber, maxNumber) = readln().split(' ').map { it.toInt() }

        var excludedNumbers = 0

        if (numbers.size == 1) {
            excludedNumbers = if (numbers[0] in minNumber..maxNumber) 0 else 1
        } else {
            var leftIndex = 0
            var rightIndex = numbers.size - 1

            // находим максимальный элемент, который меньше минимума
            while (leftIndex < rightIndex) {
                val middleIndex = (leftIndex + rightIndex + 1) / 2

                if (numbers[middleIndex] < minNumber) {
                    leftIndex = middleIndex
                } else {
                    rightIndex = middleIndex - 1
                }
            }

            // если у нас первый элемент (который при бинарном поиске должен быть правильным ответом)
            // больше либо равен минимальной границе, то в нашем массиве элементов, меньших минимума, нет
            val excludedNumbersLeft = if (numbers[leftIndex] >= minNumber) 0 else leftIndex + 1

            // находим все элементы, которые больше максимума
            leftIndex = 0
            rightIndex = numbers.size - 1

            while (leftIndex < rightIndex) {
                val middleIndex = (leftIndex + rightIndex) / 2

                if (numbers[middleIndex] > maxNumber) {
                    rightIndex = middleIndex
                } else {
                    leftIndex = middleIndex + 1
                }
            }
            // если у нас последний элемент (который при бинарном поиске должен быть правильным ответом)
            // меньше либо равен максимальной границе, то в нашем массиве элементов, больших максимума, нет
            val excludedNumbersRight = if (numbers[leftIndex] <= maxNumber) 0 else numbers.size-leftIndex

            excludedNumbers=excludedNumbersLeft+excludedNumbersRight
        }

        val entries = numbers.size - excludedNumbers

        answers.add(entries)
    }

    println(answers.joinToString(" "))

    val end = System.currentTimeMillis()

    println("Execution time is ${end - begin} ms")

}