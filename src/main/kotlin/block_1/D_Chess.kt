package org.example.block_1

fun chess() {

    val chessArray = Array(8) { CharArray(8) }

    var numberOfCellsUnderAttack = 0

    var numberOfNonEmptyCells = 0
    repeat(8) { index ->
        val inputString = readln()

        numberOfNonEmptyCells += inputString.filter { it == 'R' || it == 'B' }.length

        chessArray[index] = inputString.toCharArray()
    }

    for (i in chessArray.indices) {

        for (j in 0 until chessArray[i].size) {

            var isTopStopCell = false
            var isBottomStopCell = false
            var isLeftStopCell = false
            var isRightStopCell = false
            var isTopLeftDiagonalStopCell = false
            var isBottomLeftDiagonalStopCell = false
            var isTopRightDiagonalStopCell = false
            var isBottomRightDiagonalStopCell = false

            if (chessArray[i][j] == '*') {
                var stepFromCell = 1

                while (stepFromCell < 8) {

                    if (i - stepFromCell >= 0 && !isTopStopCell) {
                        val cell = chessArray[i - stepFromCell][j]
                        if (cell != '*') {
                            if (cell == 'R') {
                                numberOfCellsUnderAttack++
                                break
                            }

                            isTopStopCell = true
                        }
                    }

                    if (i + stepFromCell < 8 && !isBottomStopCell) {
                        val cell = chessArray[i + stepFromCell][j]
                        if (cell != '*') {
                            if (cell == 'R') {
                                numberOfCellsUnderAttack++
                                break
                            }
                            isBottomStopCell = true
                        }
                    }

                    if (j - stepFromCell >= 0 && !isLeftStopCell) {
                        val cell = chessArray[i][j - stepFromCell]
                        if (cell != '*') {
                            if (cell == 'R') {
                                numberOfCellsUnderAttack++
                                break
                            }
                            isLeftStopCell = true
                        }
                    }

                    if (j + stepFromCell < 8 && !isRightStopCell) {
                        val cell = chessArray[i][j + stepFromCell]
                        if (cell != '*') {
                            if (cell == 'R') {
                                numberOfCellsUnderAttack++
                                break
                            }
                            isRightStopCell = true
                        }
                    }

                    if (i - stepFromCell >= 0 && j - stepFromCell >= 0 && !isTopLeftDiagonalStopCell) {
                        val cell = chessArray[i - stepFromCell][j - stepFromCell]
                        if (cell != '*') {
                            if (cell == 'B') {
                                numberOfCellsUnderAttack++
                                break
                            }
                            isTopLeftDiagonalStopCell = true
                        }
                    }

                    if (i + stepFromCell < 8 && j + stepFromCell < 8 && !isBottomRightDiagonalStopCell) {

                        val cell = chessArray[i + stepFromCell][j + stepFromCell]
                        if (cell != '*') {
                            if (cell == 'B') {
                                numberOfCellsUnderAttack++
                                break
                            }
                            isBottomRightDiagonalStopCell = true
                        }

                    }

                    if (i - stepFromCell >= 0 && j + stepFromCell < 8 && !isTopRightDiagonalStopCell) {
                        val cell = chessArray[i - stepFromCell][j + stepFromCell]
                        if (cell != '*') {
                            if (cell == 'B') {
                                numberOfCellsUnderAttack++
                                break
                            }
                            isTopRightDiagonalStopCell = true
                        }

                    }

                    if (i + stepFromCell < 8 && j - stepFromCell >= 0 && !isBottomLeftDiagonalStopCell) {
                        val cell = chessArray[i + stepFromCell][j - stepFromCell]
                        if (cell != '*') {
                            if (cell == 'B') {
                                numberOfCellsUnderAttack++
                                break
                            }
                            isBottomLeftDiagonalStopCell = true
                        }
                    }

                    stepFromCell++
                }
            }
        }
    }
    val nonAttackingCells = 64 - numberOfCellsUnderAttack - numberOfNonEmptyCells

    println(nonAttackingCells)
}