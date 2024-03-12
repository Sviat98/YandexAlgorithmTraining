package org.example.season_5.block_2

fun perimeter() {
    val numOfCutOffCells = readln().toInt()

    val chessArray = Array(10) { Array(10) { 0 } }

    var perimeter = 0

    val dx = listOf(0, -1, 0, 1)

    val dy = listOf(-1, 0, 1, 0)

    repeat(numOfCutOffCells) {
        val (cutOffPointX, cutOffPointY) = readln().split(' ').map { it.toInt() }

        chessArray[cutOffPointX][cutOffPointY] = 1
    }

    for (x in 1..8) {
        for (y in 1..8) {
            if (chessArray[x][y] == 1) {
                for (k in 0..3) {
                    val neighbour = chessArray[x + dx[k]][y + dy[k]]

                    if (neighbour == 0) {
                        perimeter++
                    }
                }
            }
        }
    }

    println(perimeter)
}