package org.example.season_5.block_3

fun anagram() {
    val firstString = readln().filter { it != ' ' }.toCharArray().sorted().joinToString("")

    val secondString = readln().filter { it != ' ' }.toCharArray().sorted().joinToString("")

    var answer = "YES"

    firstString.forEachIndexed { index, c ->
        if(c != secondString[index]){
            answer = "NO"
            return@forEachIndexed
        }
    }

    println(answer)

}