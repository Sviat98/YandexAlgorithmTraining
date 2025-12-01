package org.example.season_6.block_3

import java.util.LinkedList


fun rightBracketSequence() {

    val brackets = readln()

    val bracketsStack = LinkedList<Char>()

    var answer = "no"

    var isClosingBracketOnEmptyStack = false
    run loop@{
        brackets.forEach { bracket ->

            if (listOf('{', '(', '[').contains(bracket)) {
                bracketsStack.push(bracket)
            } else if (bracketsStack.isEmpty()) { //если сразу пришла закрывающая скобка - выходим из цикла
                isClosingBracketOnEmptyStack = true
                return@loop
            } else {
                val topBracket = bracketsStack.peek()
                if (((topBracket == '{' && bracket == '}') || (topBracket == '(' && bracket == ')')) || ((topBracket == '[' && bracket == ']'))) {
                    bracketsStack.pop()
                }else{
                    return@loop // пришла закрывающая скобка, а там не та открывающая скобка - выходим из цикла
                }
            }

        }

    }

    if (bracketsStack.isEmpty() && !isClosingBracketOnEmptyStack) {
        answer = "yes"
    }

    println(answer)
}