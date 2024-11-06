package org.example.season_6.block_2

import java.io.File

fun compositionSum() {
//    val numbersAmount = readln().toInt()
//
//
//    val numbers = readln().split(' ').map { it.toBigInteger() }

    val inputInfo = File("input.txt").inputStream().readBytes().toString(Charsets.UTF_8).split("\r\n")
    val numbersAmount = inputInfo[0].toInt()

    val numbers = inputInfo[1].split(' ').map { it.toBigInteger() }

    val MODULE = 1_000_000_007.toBigInteger()

    val start = System.currentTimeMillis()

    var result = 0.toBigInteger()

    if (numbers.size == 3) {
        result = (numbers[0] * numbers[1] * numbers[2]).mod(MODULE)
    } else {
        var prefixSum = 0.toBigInteger()

        val prefixSums = mutableListOf(0.toBigInteger())

        numbers.forEach { number ->
            prefixSum += number

            prefixSums.add(prefixSum)
        }

        val prefixSumsLeftIndex = 2
        val prefixSumsRightIndex = numbers.size

        val mostRightIndex = numbers.size-1
        val leftEdge = (numbers[0]*numbers[1]*(prefixSums[prefixSumsRightIndex]-prefixSums[prefixSumsLeftIndex])).mod(MODULE)

        val rightEdge = (numbers[mostRightIndex]*numbers[mostRightIndex-1]* prefixSums[prefixSumsRightIndex-2]).mod(MODULE)

        var middle = 0.toBigInteger()

        if (mostRightIndex>3){
            for (i in 2..mostRightIndex-2){
               middle+=(numbers[i]*(prefixSums[i])*(prefixSums[prefixSumsRightIndex]-prefixSums[i+1])).mod(MODULE)
                }
            }

           result = (leftEdge+rightEdge+middle).mod(MODULE)
    }

    println(result)

    val end = System.currentTimeMillis()

    print("Total time ${end - start} ms")

}