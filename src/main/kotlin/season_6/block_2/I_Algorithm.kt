package org.example.season_6.block_2

fun algorithm(){
    val algorithmAmount = readln().toInt()

    val interesting = readln().split(' ').map { it.toInt() }

    val usefulness = readln().split(' ').map { it.toInt() }

    val mood = readln().split(' ').map { it.toInt() }

    val algorithmTriple = mood.mapIndexed { index,_ -> Triple(index+1,interesting[index],usefulness[index]) }

    val algorithmTripleByInterest = algorithmTriple.sortedWith(compareByDescending<Triple<Int,Int,Int>> { it.second }.thenBy { it.third }.thenBy { it.first })

    val algorithmTripleByUsefulness = algorithmTriple.sortedWith(compareByDescending<Triple<Int,Int,Int>> { it.third }.thenBy { it.second }.thenBy { it.first })

    val usedAlgorithms = mutableSetOf<Int>()

    var interestPointer = 0
    var usefulnessPointer = 0

    mood.forEachIndexed {index, day->
        if (day==0){
            usedAlgorithms.add(algorithmTripleByInterest[interestPointer].first)
            
        }else{
            usedAlgorithms.add(algorithmTripleByUsefulness[usefulnessPointer].first)
        }
    }

}