package org.example.season_6.block_3

import java.util.LinkedList

fun lineLand() {
    val citiesAmount = readln().toInt()

    val cityCosts = readln().split(' ').mapIndexed { index, item -> Pair(index, item.toInt()) }

    val cityStack = LinkedList<Pair<Int, Int>>()

    val relocatedCityIndexes = mutableListOf<Int>()

    var currentCityCost: Pair<Int, Int> = Pair(-1, 0)

    repeat(citiesAmount) {
        relocatedCityIndexes.add(-1)
    }

    cityCosts.forEach { cityCost ->
        currentCityCost = cityStack.peek()
        while (cityStack.isNotEmpty() && cityCost.second < currentCityCost.second) {
            cityStack.pop()
            relocatedCityIndexes[currentCityCost.first] = cityCost.first
            currentCityCost = cityStack.peek()
        }

        cityStack.push(cityCost)
    }

    println(relocatedCityIndexes.joinToString(" "))
}