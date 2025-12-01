package org.example.season_6.block_3

import java.math.BigInteger
import java.util.LinkedList

fun stackSum() {
    val requestsAmount = readln().toInt()

    val requests = mutableListOf<String>()

    val stack = LinkedList<BigInteger>()

    var stackSum = 0.toBigInteger()

    val prefixSums = mutableListOf<BigInteger>(0.toBigInteger())

    repeat(requestsAmount){
        val request = readln()

        requests.add(request)
    }

   requests.forEach{request->

        when{
            request.startsWith('+')->{
                val number = request.substring(1).toBigInteger()

                stackSum+=number
                prefixSums.add(stackSum)
                stack.push(number)
            }
            request=="-"->{
                val number = stack.peek()

                println(number)

                prefixSums.removeAt(stack.size)

                stack.pop()
                stackSum-=number
            }
            request.startsWith('?')->{
                val numbersAmountToSum = request.substring(1).toInt()

                val sum = stackSum-prefixSums[stack.size-numbersAmountToSum]

                println(sum)
            }
        }
    }
}