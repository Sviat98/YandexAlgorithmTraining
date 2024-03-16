package org.example.season_5.block_2

fun warships() {
    val numOfWarships = readln().toInt()

    val battleField = Array(numOfWarships + 2) { Array(numOfWarships + 2) { 0 } }

    var totalShifts = 0

    repeat(numOfWarships) {
        val (warshipX, warshipY) = readln().split(' ').map { it.toInt() }

        battleField[warshipX] [warshipY] = 1
    }

    for(row in battleField){

        for(cell in row){
            print("$cell \t")
        }
        println()
    }

//    for(index in 1 until numOfWarships){
//        val row = battleField[index]
//
//        val warshipsPerRow = row.sum()
//
//        while(warshipsPerRow>1){
//            val targetRow = battleField.find { it.sum() == 0 }
//
//            val targetRowIndex = battleField.indexOf(targetRow)
//
//            val rowDiff
//        }
//    }
}