package org.example.season_5.block_1

import kotlin.math.abs
import kotlin.math.absoluteValue

fun mathProblem() {
    val amountOfNumbers = readln().toInt()

    val numbersString = readln().split(' ').map {
        val number = abs(it.toInt())
        if (number % 2 == 1) 1 else 0
    }.joinToString(" ")

    println(numbersString.filter { it == '0' }.length)
    println(numbersString.filter { it == '1' }.length)

    val start = System.currentTimeMillis()

    val multiplyChar = 120.toChar()

    val twoOddNumbersWithSpace = "1 1"

    val twoEvenNumbersWithSpace = "0 0"


    var expressionString = numbersString

    while (expressionString.contains(twoOddNumbersWithSpace)) {
        expressionString =
            expressionString.replace(
                twoOddNumbersWithSpace,
                "1${multiplyChar}1"
            )//там, где 2 нечетных, нужно поставить умножение
    }


    while (expressionString.contains(twoEvenNumbersWithSpace)) {
        expressionString =
            expressionString.replace(
                twoEvenNumbersWithSpace,
                "0${multiplyChar}0"
            )//там, где 2 нечетных, нужно поставить умножение
    }

    val optimizedNumbersList = expressionString.split(' ')

    val amountOfOddNumbers = optimizedNumbersList.filter {
        it.startsWith('1')
    }.size

    if (amountOfOddNumbers % 2 == 0) {
        expressionString = expressionString.replaceFirst(' ', multiplyChar)
    }

    expressionString = expressionString.replace(' ', '+')

    val signsString = expressionString.filter { it == '+' || it == multiplyChar }

    println(signsString)

    val end = System.currentTimeMillis()
    println("execution time = ${end - start} ms")
}