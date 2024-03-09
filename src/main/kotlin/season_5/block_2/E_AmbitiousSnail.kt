package org.example.season_5.block_2

import kotlin.math.max

fun ambitiousSnail() {
    val numberOfBerries = readln().toInt()

    val berries = mutableListOf<Triple<Int, Int, Int>>()

    repeat(numberOfBerries) {
        val berryParams = readln().split(' ').map { it.toInt() }

        val berryStrength = berryParams[0] - berryParams[1]

        val berryMaxHeight = berryParams[0]

        val berryNumber = it + 1

        val berry = Triple(berryNumber, berryStrength, berryMaxHeight)

        berries.add(berry)
    }



    berries.sortByDescending { it.second }


    val berriesWithPositiveStrength = berries.filter { it.second > 0 }

    println("berries = $berries")


    val extraHeight = if (berriesWithPositiveStrength.lastIndex < berries.size - 1)
        berries[berriesWithPositiveStrength.lastIndex + 1].third else 0

    println("extraHeight = $extraHeight")


    val maxHeight = berriesWithPositiveStrength.sumOf { it.second } + extraHeight

    println(maxHeight)

    println(berries.map { it.first }.joinToString(" "))

}