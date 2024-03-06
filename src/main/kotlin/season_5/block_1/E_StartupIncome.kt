package org.example.season_5.block_1

import kotlin.math.pow

fun startupIncome() {
    val (initialIncome, numberOfFounders, daysToFollow) = readln().split(' ').map { it.toInt() }

    val start = System.currentTimeMillis()

    var currentIncome = initialIncome.toString()

    // ищем, какую цифру можно дописать
    var nextDigit = -1

    if (initialIncome % numberOfFounders != 0) {
        (0..9).forEach {
            val possibleIncome = currentIncome + it.toString()

            if (possibleIncome.toInt() % numberOfFounders == 0) {
                nextDigit = it
            }
        }
    } else {
        nextDigit = 0
    }

    if (nextDigit==-1){
        currentIncome = nextDigit.toString()
    }else{
        currentIncome+=nextDigit
            currentIncome+="0".repeat(daysToFollow-1)
    }

    println(currentIncome)

    val end = System.currentTimeMillis()
    println("execution time = ${end - start} ms")
}