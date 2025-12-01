package org.example.leetcode

import kotlin.math.pow

fun integerToRoman(num: Int): String {
    var number = num

    val thousands = number / 1000

    var result = ""

    if (thousands != 0) {
        result += "M".repeat(thousands)
        number -= 1000 * thousands
    }

    for (i in 2 downTo 0) {
        val minimalDimensionRomanNumber = when (i) {
            2 -> "C"
            1 -> "X"
            0 -> "I"
            else -> ""
        }

        val fifthDimensionRomanNumber = when (i) {
            2 -> "D"
            1 -> "L"
            0 -> "V"
            else -> ""
        }

        val maximumDimensionRomanNumber = when (i) {
            2 -> "M"
            1 -> "C"
            0 -> "X"
            else -> ""
        }

        val digit = number / 10.0.pow(i).toInt()

        val appendRomanNumbers = when (digit) {
            4 -> "$minimalDimensionRomanNumber$fifthDimensionRomanNumber"
            9 -> "$minimalDimensionRomanNumber$maximumDimensionRomanNumber"
            else -> {
                if (digit > 4) fifthDimensionRomanNumber + minimalDimensionRomanNumber.repeat(digit - 5) else minimalDimensionRomanNumber.repeat(
                    digit
                )
            }
        }
        number -= digit * 10.0.pow(i).toInt()

        result += appendRomanNumbers
    }

    return result
}