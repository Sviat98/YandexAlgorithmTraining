package org.example.season_5.block_2

import kotlin.math.max

fun fishPrice() {
    val (totalDays, fishExpirationDays) = readln().split(' ').map { it.toInt() }

    val fishPrices = readln().split(' ').map { it.toInt() }

    var totalMaxIncome = 0

    for (index in 0 until totalDays) {
        val fishPriceToBuy = fishPrices[index]

        val possibleFishPrices = fishPrices.filterIndexed { i, _ -> i in (index + 1).. index + fishExpirationDays }

        val maxIncome = possibleFishPrices
            .maxOfOrNull { it - fishPriceToBuy } ?: 0// если купили в последний день, то прибыль 0

        if (maxIncome > totalMaxIncome) {
            totalMaxIncome = maxIncome
        }
    }

    println(totalMaxIncome)
}