package org.example.season_6.block_2

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

fun removeMiddle(){
    val numbersAmount = readln().toInt()

    val numbers = readln().split(' ').map { it.toInt() }.sorted().toMutableList()

    val start = System.currentTimeMillis()

    val orderedList = mutableListOf<Int>()

    if(numbers.size==1){
        orderedList.add(numbers[0])
    }else{
        var left = 0
        var right = 0

        if (numbers.size.mod(2) ==1){
            right = (numbers.size-1)/2
            left = right
        }else{
            right = numbers.size/2
            left = right-1
        }


        while (numbers.size>2){
            if (left==right){
                orderedList.add(numbers[left])
                numbers.removeAt(left)

                left--
            }else if (numbers[left] == numbers[right]){
                orderedList.add(numbers[right])
                numbers.removeAt(right)
                right--
            }else{
                orderedList.add(numbers[left])
                numbers.removeAt(left)
                right--
            }
        }

        orderedList.add(numbers[0])
        orderedList.add(numbers[1])

   }


    println(orderedList.joinToString(" "))

    val end = System.currentTimeMillis()

    println("${end-start} ms")
}

fun removeMiddleNew(){
//    val numbersAmount = readln().toInt()
//
//    val numbers = readln().split(' ').map { it.toInt() }.sorted().toMutableList()

    val inputInfo = File("input.txt").inputStream().readBytes().toString(Charsets.UTF_8).split("\r\n")
    val  numbersAmount = inputInfo[0].toInt()

    val numbers =inputInfo[1].split(' ').map { it.toInt() }

    val start = System.currentTimeMillis()

    val reverseOrderedList = mutableListOf<Int>()

    val numbersMap = numbers.groupingBy { it }.eachCount().toMutableMap().toSortedMap()

    while (numbersMap.size>1){
        val numberEntry = numbersMap.entries.last()
        val number = numberEntry.key

        reverseOrderedList.add(number)
        if (numbersMap[number]==1){
            numbersMap.remove(number)
        }else{
            var value = numberEntry.value -1
            numbersMap.put(number,value)
        }

        if(numbersMap.size!=1){
            val numberEntry = numbersMap.entries.first()
            val number = numberEntry.key

            reverseOrderedList.add(number)

            if (numbersMap[number]==1){
                numbersMap.remove(number)
            }else{
                var value = numberEntry.value -1
                numbersMap.put(number,value)
            }
        }
    }

    val remainingEntry = numbersMap.entries.first()

    val remainingValues = remainingEntry.value

    repeat(remainingValues){
        reverseOrderedList.add(remainingEntry.key)
    }

    val orderedList = reverseOrderedList.reversed()

    val outputStream = BufferedWriter(FileWriter("output.txt"))
    outputStream.write(orderedList.joinToString(" "))
    outputStream.flush()
    outputStream.close()

    val end = System.currentTimeMillis()

    println("${end-start} ms")
}