package org.example.season_6.block_2

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

fun monuments(){

//    val  (monumentsAmount,minDistance) = readln().split(' ').map { it.toInt() }
//
//    val monuments =readln().split(' ').map { it.toInt() }
    val inputInfo = File("input.txt").inputStream().readBytes().toString(Charsets.UTF_8).split("\r\n")
    val  (monumentsAmount,minDistance) = inputInfo[0].split(' ').map { it.toInt() }

    val monuments =inputInfo[1].split(' ').map { it.toInt() }

    val start = System.currentTimeMillis()
    var right = 0

    var numOfMonumentPairs = 0L

    for(left in 0 until monuments.size){
        while (right<monuments.size && monuments[right] - monuments[left]<=minDistance){
            right++;
        }
        numOfMonumentPairs+=monuments.size - right
    }

    val outputStream = BufferedWriter(FileWriter("output.txt"))
    outputStream.write(numOfMonumentPairs.toString())
    outputStream.flush()
    outputStream.close()

    val end = System.currentTimeMillis()

    println(" Total time ${end-start} ms")

//    println(numOfMonumentPairs)
}