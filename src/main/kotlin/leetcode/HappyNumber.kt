package org.example.leetcode

import kotlin.math.pow

fun isHappy(n: Int): Boolean {
    var result = 0

    var number = n
    while (result !in listOf(1,4)) {
        result = 0

        for (decimalPower in 9 downTo 0) {

            val digit = number / 10.0.pow(decimalPower).toInt()

            number -= digit * 10.0.pow(decimalPower).toInt()

            result += digit * digit
        }
        number = result
    }

    return result == 1
}