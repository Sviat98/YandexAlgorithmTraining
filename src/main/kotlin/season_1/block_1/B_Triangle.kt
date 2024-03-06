package org.example.season_1.block_1

fun triangle() {
    val triangleSides = mutableListOf<Int>()

    repeat(3) {
        val triangleSide = readLine()!!.toInt()
        triangleSides.add(triangleSide)
    }

    var result = "YES"

    triangleSides.forEachIndexed { i, side ->

        val otherSidesSum = triangleSides.filterIndexed { index, _ -> index != i }.sum()

        if (side >= otherSidesSum) {
            result = "NO"
            return@forEachIndexed
        }
    }

    println(result)
}