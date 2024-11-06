package org.example.season_6.block_2


fun prefixSum() {

    val file = java.io.File("input.txt")
    file.createNewFile()
    val inputInfo = file.inputStream().readBytes().toString(Charsets.UTF_8).split("\r\n")
    val  n = inputInfo[0].toInt()

    val numbers =inputInfo[1].split(' ').map { it.toInt() }
//    val n = readln().toInt()
//
//    val numbers = readln().split(' ').map { it.toInt() }

    var prefixSum = 0

    val prefixSums = mutableListOf<Int>()

    numbers.forEach { number->
        prefixSum+=number

        prefixSums.add(prefixSum)
    }

    val outputStream = java.io.BufferedWriter(java.io.FileWriter("output.txt"))
    outputStream.write(prefixSums.joinToString(" "))
    outputStream.flush()
    outputStream.close()

    println(prefixSums.joinToString(" "))
}