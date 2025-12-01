package org.example.season_6.block_3

import java.util.LinkedList

fun minimalRightBracketSequence() {
    val answerLength = readln().toInt()

    val bracketsOrder = readln()

    val bracketsByPriority = bracketsOrder.mapIndexed { index, symbol -> Pair(index, symbol) }

    val openingRoundBracket = bracketsByPriority.first { pair -> pair.second == '(' }
    val openingSquareBracket = bracketsByPriority.first { pair -> pair.second == '[' }
    val closingRoundBracket = bracketsByPriority.first { pair -> pair.second == ')' }
    val closingSquareBracket = bracketsByPriority.first { pair -> pair.second == ']' }

    val minimalOpeningBracket =
        bracketsByPriority.filter { pair -> pair.second in listOf('(', '[') }.minBy { it.first }


    var beginAnswer = readln()

    var answer = ""

    var endAnswer = ""

    val stack = LinkedList<Char>()

    beginAnswer.forEach { bracket ->
        if (listOf('(', '[').contains(bracket)) {
            stack.push(bracket)
        } else {
            stack.pop()
        }
    }

    val remainingSymbols = answerLength - beginAnswer.length

    var remainingOpeningBrackets = remainingSymbols/2 - stack.size

    repeat (remainingSymbols){

           val bracket = stack.peek()

            val minimalPossibleBracket = when (bracket){
                '['-> {
                    bracketsByPriority.filter { pair -> pair.second != ')' }.minBy { pair -> pair.first }
                }
                '('-> bracketsByPriority.filter { pair -> pair.second != ']' }.minBy { pair -> pair.first }
                else -> minimalOpeningBracket
            }

            if (minimalPossibleBracket == minimalOpeningBracket && remainingSymbols-it > stack.size){
                stack.push(minimalPossibleBracket.second)
                endAnswer+=minimalPossibleBracket.second
            }else{
                val closingBracket = if (bracket == '[') ']' else ')'
                endAnswer+=closingBracket

                stack.pop()
            }
    }

    answer = beginAnswer+endAnswer

    println(answer)
}