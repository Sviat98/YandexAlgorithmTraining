package org.example.season_5.block_2

fun rope() {
    val numberOfLeftPieces = readln().toInt()

    var hiddenPiece = 0

    val leftPieces = readln().split(' ').map { it.toInt() }

    val maxPiece = leftPieces.max()

    val maxPieceIndex = leftPieces.indexOf(maxPiece)

    val leftPiecesWithoutMaxSum = leftPieces.filterIndexed { index, _ -> index != maxPieceIndex }.sum()

    if (maxPiece-leftPiecesWithoutMaxSum>0){
        hiddenPiece = maxPiece-leftPiecesWithoutMaxSum
    }else{
        hiddenPiece = maxPiece+leftPiecesWithoutMaxSum
    }

    println(hiddenPiece)
}