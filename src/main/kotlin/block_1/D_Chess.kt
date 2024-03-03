package org.example.block_1

fun chess(){

    // B-слон, ходит под диагонали
    // R-ладья, ходит по горизонтали и вертикали

    val chessArray = mutableListOf<String>()
    var rColumn = -1
    var rRow = -1
    var bColumn = -1
    var bRow = -1
    repeat(8){
        val inputString = readln()

        chessArray.add(inputString)
    }

    chessArray.forEachIndexed {index, chessRow->
        val isRowWithR = chessRow.contains('R',false)

        if(isRowWithR){
            rRow = index
            rColumn = chessRow.indexOf('R')
        }

        val isRowWithB = chessRow.contains('B',false)

        if(isRowWithB){
            bRow = index
            bColumn = chessRow.indexOf('B')
        }

    }

    println("R in $rRow $rColumn")

    println("B in $bRow $bColumn")


    println(chessArray)
}