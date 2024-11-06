package org.example.season_6.block_2

fun luckyNumber() {
    val (numbersAmount, luckyNumber) = readln().split(' ').map { it.toInt() }

    val carNumbers = readln().split(' ').map { it.toInt() }

    val prefixSumsMap = mutableMapOf(0 to mutableListOf(0))

    var prefixSum = 0

    var numberOfPairs = 0

    if (luckyNumber == 1) {
        numberOfPairs = carNumbers.filter { it==1 }.size
    } else {
        carNumbers.forEach { carNumber ->
            prefixSum+=carNumber

            val key = prefixSum.mod(luckyNumber)

            val prefixSumIntPart = prefixSum / luckyNumber

            val prefixSumIntPartList = prefixSumsMap[key] ?: mutableListOf()

            prefixSumIntPartList.add(prefixSumIntPart)

            prefixSumsMap.put(key, prefixSumIntPartList)
        }

        prefixSumsMap.filter { it.value.size > 1 }.forEach { entry ->
            val list = entry.value

            var pairsInList = 0

            for (i in list.size -1  downTo 1) {
                if (list[i] - list[i - 1] == 1) {
                    pairsInList++;
                }
            }

            numberOfPairs += pairsInList
        }
    }

    println(numberOfPairs)
}