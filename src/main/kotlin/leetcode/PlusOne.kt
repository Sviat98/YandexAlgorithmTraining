package org.example.leetcode

import kotlin.math.pow

fun plusOne(digits: IntArray): List<Int>{
    var maxDecimalPower = digits.size - 1

    var intNumber  = 0.toBigInteger()

    var isMaxDecimalPowerIncrease = true

    for(i in 0 until digits.size){
        val decimalPower = maxDecimalPower-i

        intNumber+= (10.toBigInteger().pow(decimalPower)*digits[i].toBigInteger())

        if (digits[i] != 9 && isMaxDecimalPowerIncrease){
            isMaxDecimalPowerIncrease = false
        }
    }

    intNumber+=1.toBigInteger()

    val result = mutableListOf<Int>()

    if (isMaxDecimalPowerIncrease){
        maxDecimalPower+=1
    }

    var decimalPower = maxDecimalPower

    while(decimalPower>-1){
        val resultDigit = intNumber / 10.toBigInteger().pow(decimalPower)
        intNumber-= resultDigit * (10.toBigInteger().pow(decimalPower))

        result.add(resultDigit.toInt())

        decimalPower--
    }

    return result
}