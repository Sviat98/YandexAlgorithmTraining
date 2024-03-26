package org.example.season_5.block_4

import java.math.BigInteger

fun lineWarships() {
    val cellsAmount = readln().toLong()

    val begin = System.currentTimeMillis()

    var maxShipSizeLeft = 0L
    var maxShipSizeRight = cellsAmount

    while (maxShipSizeLeft < maxShipSizeRight) {
        val maxShipSizeMiddle = (maxShipSizeLeft + maxShipSizeRight + 1) / 2

        if (countCellsByShipMaxSize(maxShipSizeMiddle) <= cellsAmount.toBigInteger()) {
            maxShipSizeLeft = maxShipSizeMiddle
        } else {
            maxShipSizeRight = maxShipSizeMiddle - 1
        }
    }

    println(maxShipSizeLeft)

    val end = System.currentTimeMillis()

    println("Execution time is ${end - begin} ms")
}

private fun countCellsByShipMaxSize(k: Long): BigInteger {
    // (k-1)*k/2 -  количество свободных клеток в рамках группы кораблей
    // k-1 -  количество свободных клеток между группами кораблей

    val totalShipCellsAmount: BigInteger

    if (k % 2 == 1L) {
        val n = k / 2 + 1
        totalShipCellsAmount =
            n.toBigInteger() * (2 * n - 1).toBigInteger() * (2 * n + 1).toBigInteger() / 3.toBigInteger();
    } else {
        val n = k / 2
        totalShipCellsAmount =
            2.toBigInteger() * n.toBigInteger() * (n + 1).toBigInteger() * (2 * n + 1).toBigInteger() / 3.toBigInteger();
    }

    val sum =
        totalShipCellsAmount + k.toBigInteger() * (k - 1).toBigInteger() / 2.toBigInteger() + (k - 1).toBigInteger()
    return sum
}

fun squareSum135(k: Int): BigInteger {
    val maxNumberInSequence = 2 * k - 1
    return k.toBigInteger() * (2 * maxNumberInSequence - 1).toBigInteger() * (2 * maxNumberInSequence + 1).toBigInteger() / 3.toBigInteger()
}
