package org.example.advent2025.day5

import java.io.File
import java.io.FileReader

fun findFreshIngredients_1(): Int{
    val pathToFile = "src/main/kotlin/advent2025/day5/input.txt"
    val file = File(pathToFile)
    val reader = FileReader(file)
    val lines = reader.readLines()

    val freshIngredientsRanges = mutableListOf<Pair<Long,Long>>()
    val freshIngredients = mutableSetOf<Long>()

    lines.filter { it.isNotEmpty() }.forEach { line->
        if(line.contains("-")){
            val (beginRange,endRange) = line.split('-').map { it.toLong() }

            freshIngredientsRanges.add(Pair(beginRange,endRange))
        }else{
            val ingredient = line.toLong()

            freshIngredientsRanges.forEach { (beginRange,endRange)->
                if (ingredient in beginRange..endRange){
                    freshIngredients.add(ingredient)
                }
            }
        }
    }

    return freshIngredients.size
}