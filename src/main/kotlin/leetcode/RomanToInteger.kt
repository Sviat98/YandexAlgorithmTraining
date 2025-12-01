package org.example.leetcode

fun romanToInt(s: String): Int {
    val romanNumbers = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

    var result = 0
    var currentMaxIntValue = 0
    for (i in s.length - 1 downTo 0) {
        val intValue = romanNumbers[s[i]] ?: 0

        if (intValue < currentMaxIntValue) {
            result -= intValue
        } else {
            result += intValue
        }

        currentMaxIntValue = intValue
    }

    return result
}