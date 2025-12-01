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

    var prefixSum = numbers[0]

    var suffixSum = numbers.sumOf { it } - numbers[0] - numbers[1]

    for (i in 1..numbers.size - 2) {
        result += (numbers[i] * prefixSum * suffixSum).mod(MODULE)
        prefixSum += (numbers[i]).mod(MODULE)
        suffixSum -= numbers[i + 1].mod(MODULE)
    }

    println(result.mod(MODULE))

    val end = System.currentTimeMillis()

    print("Total time ${end - start} ms")
}