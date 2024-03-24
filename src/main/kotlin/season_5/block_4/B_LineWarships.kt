package org.example.season_5.block_4

fun lineWarships() {


    val k = readln().toInt()

    var sum = 0

    (1..k).forEach { number ->

        val index = number - 1

        val oppositeNumber = k-index
        val stepSum = number * oppositeNumber+index

        sum += stepSum
    }

    sum+=k-1

    println(sum)
}