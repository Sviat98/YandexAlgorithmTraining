package org.example.season_6.block_1

fun letters(){
    val numberOfRows = readln().toInt()

    var inputArray = Array(numberOfRows){CharArray(numberOfRows)}

    repeat(numberOfRows) { index ->
        val inputString = readln()

        inputArray[index] = inputString.toCharArray()
    }

    inputArray = compress(inputArray)

//    for (i in inputArray.indices){
//        println(inputArray[i])
//    }
}

private fun compress(array: Array<CharArray>): Array<CharArray>{
    val newArray = arrayOf<CharArray>()

    val numOfCharsInARow = array.first().size

    for (i in array.indices){
        if (array[i] contentEquals ".".repeat(numOfCharsInARow).toCharArray()){
            array.drop(i)
        }
    }
    for (i in 0 until array.size-1){
        println(array[i])
        if (array[i] contentEquals array[i+1]){
            newArray.fill(array[i])
        }
    }

    return newArray
}