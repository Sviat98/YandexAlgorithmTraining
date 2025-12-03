package org.example.advent2025.day3

import java.io.File
import java.io.FileReader

fun findJoltage_1(): Int{
    val pathToFile = "src/main/kotlin/advent2025/day3/input.txt"
    val file = File(pathToFile)
    val reader = FileReader(file)
    val lines = reader.readLines()

    var joltageSum = 0

    lines.forEach { line ->
        var maxDecimalDigit =0
        var maxSecondDigit = 0
        for (decimalDigitIndex in 0..<line.length-1){
            val decimalDigit = line[decimalDigitIndex].toString().toInt()

            if (decimalDigit>maxDecimalDigit){
                maxDecimalDigit = decimalDigit
                maxSecondDigit = 0
            }

            for (secondDigitIndex in decimalDigitIndex+1..<line.length){
                val secondDigit = line[secondDigitIndex].toString().toInt()

                if (secondDigit>maxSecondDigit){
                    maxSecondDigit = secondDigit
                }
            }
        }

        val maxJoltage = maxDecimalDigit*10+maxSecondDigit

        joltageSum+=maxJoltage
    }

    return joltageSum
}