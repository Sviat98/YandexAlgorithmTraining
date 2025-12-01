package org.example.season_6.block_3

fun deliveryPoint(){
    val inputDataFirstString = readln().split(' ')

    val workingMinutes = inputDataFirstString[0].toInt()

    val capacity = inputDataFirstString[1].toBigInteger()

    val queue = readln().split(' ').map { string -> string.toBigInteger() }

    var totalMinutes = 0.toBigInteger()

    var queueSize = 0.toBigInteger()

    repeat(workingMinutes){minute->
        val clientsInMinute = queue[minute]
        queueSize+=clientsInMinute
        totalMinutes+=queueSize
        queueSize-=queueSize.coerceAtMost(capacity)
    }

    totalMinutes+=queueSize

    println(totalMinutes)

}