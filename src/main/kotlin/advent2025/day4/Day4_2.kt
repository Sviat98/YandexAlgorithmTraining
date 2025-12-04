package org.example.advent2025.day4

import java.io.File
import java.io.FileReader

fun countPaperRolls_2(): Int{
    val pathToFile = "src/main/kotlin/advent2025/day4/input.txt"
    val file = File(pathToFile)
    val reader = FileReader(file)
    val lines = reader.readLines()

    val paperRollsArray = Array(lines.size+2) { Array(lines.size+2) { 0 } }

    lines.forEachIndexed { index, line ->
        val row = paperRollsArray[index+1]

        line.forEachIndexed { lineIndex, symbol ->
            if(symbol=='@'){
                row[lineIndex+1] = 1
            }
        }
    }

    val paperRollsCount = removePaperRolls(array = paperRollsArray, paperRollsCounter = 0)

    return paperRollsCount
}

fun removePaperRolls(
    array: Array<Array<Int>>,
    paperRollsCounter: Int,
): Int{
    val deltaI = arrayOf(-1,-1,-1,0,1,1,1,0)
    val deltaJ = arrayOf(-1,0,1,1,1,0,-1,-1)

    val coordinates = mutableListOf<Pair<Int,Int>>()

    for (i in 1..<array.size){
        for (j in 1..<array[i].size){
            if (array[i][j]==1){
                var sum = 0

                for(deltaIndex in 0..<deltaI.size){
                    sum+=array[i+deltaI[deltaIndex]][j+deltaJ[deltaIndex]]
                }

                if(sum<4){
                    coordinates.add(Pair(i,j))
                }
            }
        }
    }

    coordinates.forEach { (i,j) ->
        array[i][j] = 0
    }

    val newPaperRollsAmount = paperRollsCounter + coordinates.size

    if (coordinates.isEmpty()){
        return newPaperRollsAmount
    }

    return removePaperRolls(
        array = array,
        paperRollsCounter = newPaperRollsAmount
    )
}