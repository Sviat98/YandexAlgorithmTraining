package org.example.season_1.block_1

import kotlin.math.pow

fun sqrt_equation() {
    val a = readLine()!!.toInt()

    val b = readLine()!!.toInt()

    val c = readLine()!!.toInt()

    var result = ""

    if (c < 0) {
        result = "NO SOLUTION"
    } else {
        val sqrC = c.toDouble().pow(2.0).toInt()

        val ax = sqrC - b

        if (a == 0) {
            result = if (ax == 0) {
                "MANY SOLUTIONS"
            } else {
                "NO SOLUTION"
            }
        } else {
            val x = if (ax % a == 0) ax / a else null

            if (x == null) {
                result = "NO SOLUTION"
            } else {
                result = if (ax + b < 0) {
                    "NO SOLUTION"
                } else {
                    x.toString()
                }
            }
        }
    }
    println(result)
}