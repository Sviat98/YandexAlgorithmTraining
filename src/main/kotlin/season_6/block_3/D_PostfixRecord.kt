package org.example.season_6.block_3

import java.util.LinkedList

fun postfixRecord(){
    val arguments = readln().trim().split(' ')

    val operandStack = LinkedList<Int>()

    val operations = listOf("+","-","*")

    arguments.forEach{arg->
        if(!operations.contains(arg)){
            operandStack.push(arg.toInt())
        }else{
            val secondArgument = operandStack.peek()
            operandStack.pop()

            val firstArgument = operandStack.peek()
            operandStack.pop()

            val result = when(arg){
                "+" -> {
                    firstArgument+secondArgument
                }
                "-" -> {
                    firstArgument-secondArgument
                }
                "*" -> {
                    firstArgument*secondArgument
                }
                else -> 0
            }

            operandStack.push(result)
        }
    }

    val answer = operandStack.peek()

    println(answer)
}