package org.example

import org.example.advent2025.day2.findInvalidIds_1
import org.example.advent2025.day2.findInvalidIds_2
import org.example.advent2025.day3.findJoltage_1

//import ambitiousSnail
//import org.example.season_1.block_1.ambulance
//import org.example.season_1.block_1.sqrt_equation
//import org.example.season_1.block_1.triangle
//import org.example.season_5.block_2.*
//import org.example.season_5.block_3.*
//import org.example.season_5.block_4.arraySearch
//import org.example.season_5.block_4.lineWarships
//import org.example.season_6.block_1.airConditioner
//import org.example.season_6.block_1.letters
//import org.example.season_6.block_1.raftAndSwimmer
//import org.example.season_6.block_1.socksAndTShirts
//import org.example.season_6.block_2.luckyNumber
import kotlin.random.Random

fun main() {
    //paintTree()
    //championsLeaguePlayOff()
    //formatFile()
    //chess()
    //startupIncome()
    //mathProblem()
    //destroyBarracks()
    //schedule()

    //ambulance()
    //triangle()
    //sqrt_equation()

    //rectangle()
    //fishPrice()
    //rope()
    //perimeter()
    //ambitiousSnail()
    //fortuneWheel()
    //noMoreNoLess()
    //warships()

    //playlist()
    //anagram()
    //deleteNumbers()
    //repeatableNumber()
    //twoOutOfThree()
    //replaceWords()
    //football()

    //arraySearch()
    //lineWarships()

    //raftAndSwimmer()
    //socksAndTShirts()
    //letters()
    //airConditioner()

    //prefixSum()
    //luckyNumber()
    //generateHugeString()
    //monuments()
    //toDoList()
    //removeMiddle()
    //removeMiddleNew()
    //compositionSum()

    //rightBracketSequence()
    //lineLand()
    //minimumInWindow()
    //postfixRecord()
    //minimalRightBracketSequence()
    //deliveryPoint()
    //stackSum()

    //readFromConsole()

//    val testStrings = listOf(Pair("1010","1011"),Pair("11","1"),
//        Pair("1111111111111111","11111"))

//    val testNumbers = listOf(3749,1994,58)
//
//    testNumbers.forEach { testNumber ->
//        println(integerToRoman(testNumber))
//    }
//
//    val testRomanNumbers = listOf("III","LVIII","MCMXCIV")
//
//    testRomanNumbers.forEach { testRomanNumber ->
//        println(romanToInt(testRomanNumber))
//    }

    println(findJoltage_1())
}

fun generateHugeString(){
    val list = mutableListOf<Int>()

    repeat(300_000){
        list.add(Random.nextInt(299000,300000))
    }

    println(list.joinToString(" "))
}

fun readFromConsole(){
    val numbers = readln().split(' ').map { it.toInt() }

    println(numbers.joinToString(" "))
}