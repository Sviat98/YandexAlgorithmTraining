package org.example.advent2025.day1

import java.io.File
import java.io.FileReader

fun countZerosOnDial_2() : Int{
    val pathToFile = "src/main/kotlin/advent2025/day1/input.txt"
    val file = File(pathToFile)
    val reader = FileReader(file)
    val lines = reader.readLines()

    var currentPoint = 50

    var numOfZeros = 0

    lines.forEach { line ->
        val direction = line.take(1)

        val directionNumber = if (direction=="L") -1 else 1

        val totalShift = line.substring(1).toInt()

        val numberOfRotations = totalShift / 100

        numOfZeros+=numberOfRotations

        val shift = totalShift % 100

        repeat(shift){
            currentPoint+=directionNumber

            currentPoint = currentPoint.mod(100)
            if(currentPoint==0){
                numOfZeros++
            }
        }
    }

    return numOfZeros
}