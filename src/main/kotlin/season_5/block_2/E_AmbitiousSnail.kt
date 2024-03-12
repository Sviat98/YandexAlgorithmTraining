package org.example.season_5.block_2

import kotlin.math.max

fun ambitiousSnail() {
    val numberOfBerries = readln().toInt()

    val berries = mutableListOf<Triple<Int, Int, Int>>()

    var maxHeight = 0L

    repeat(numberOfBerries) {
        val berryParams = readln().split(' ').map { it.toInt() }

        val berryStrength = berryParams[0] - berryParams[1]

        val berryMaxHeight = berryParams[0]

        val berryNumber = it + 1

        val berry = Triple(berryNumber, berryStrength, berryMaxHeight)

        berries.add(berry)
    }

    val sortedPositiveBerries =
        berries.filter { it.second >= 0 }
            .sortedWith(compareByDescending<Triple<Int, Int, Int>> { it.second }.thenByDescending { it.third })

    val sortedNegativeBerries =
        berries.filter { it.second < 0 }.sortedWith(compareByDescending<Triple<Int, Int, Int>> { it.third })

    val sortedBerries = sortedPositiveBerries + sortedNegativeBerries

    println(sortedBerries)

    sortedBerries.forEachIndexed { index, berry ->
        val maxHeightForBerry = sortedBerries.take(index).sumOf { it.second.toLong() } + berry.third

//        println("number = ${berry.first} index = $index sumBefore = ${sortedBerries.take(index).sumOf { it.second }} boost = ${berry.third} maxHeightForBerry = $maxHeightForBerry")

        if (maxHeightForBerry > maxHeight) {
            maxHeight = maxHeightForBerry
        }
    }

    println(maxHeight)

    println(sortedBerries.map { it.first }.joinToString(" "))
}