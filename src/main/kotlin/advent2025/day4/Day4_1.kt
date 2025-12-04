package org.example.advent2025.day4

import java.io.File
import java.io.FileReader

fun countPaperRolls_1(): Int{
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

    val deltaI = arrayOf(-1,-1,-1,0,1,1,1,0)
    val deltaJ = arrayOf(-1,0,1,1,1,0,-1,-1)

    var paperRollsCount = 0
    for (i in 1..<paperRollsArray.size){
        for (j in 1..<paperRollsArray[i].size){
            if (paperRollsArray[i][j]==1){
                var sum = 0

                for(deltaIndex in 0..<deltaI.size){
                    sum+=paperRollsArray[i+deltaI[deltaIndex]][j+deltaJ[deltaIndex]]
                }

                if(sum<4){
                    paperRollsCount++
                }
            }
        }
    }

    return paperRollsCount
}