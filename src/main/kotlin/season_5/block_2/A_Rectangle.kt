package org.example.season_5.block_2

fun rectangle() {
    val numberOfPoints = readln().toInt()

    var coordinatesX = mutableListOf<Int>()

    var coordinatesY = mutableListOf<Int>()

    repeat(numberOfPoints) {
        val (x,y) = readln().split(' ').map { it.toInt() }

        coordinatesX.add(x)

        coordinatesY.add(y)
    }

    coordinatesX.sort()

    coordinatesY.sort()

    val bottomLeftX = coordinatesX[0]

    val bottomLeftY = coordinatesY[0]

    val topRightX = coordinatesX[numberOfPoints-1]

    val topRightY = coordinatesY[numberOfPoints-1]

    println("$bottomLeftX $bottomLeftY $topRightX $topRightY")
}