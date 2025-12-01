package org.example.leetcode

import kotlin.math.abs

fun addBinary(a: String, b: String): String {

    val maxLength = a.length.coerceAtLeast(b.length)


    val firstString = a.padStart(maxLength, '0')
    val secondString = b.padStart(maxLength, '0')

    var greaterBinary = 0

    var result = ""

    for (i in maxLength - 1 downTo 0) {
        val firstDigit = firstString[i].toString().toInt()
        val secondDigit = secondString[i].toString().toInt()

        val digitSum = firstDigit + secondDigit + greaterBinary

        greaterBinary = digitSum / 2
        val resultDigit = digitSum % 2

        result = "$resultDigit$result"
    }

    if (greaterBinary == 1) {
        result = "1$result"
    }

    return result
}