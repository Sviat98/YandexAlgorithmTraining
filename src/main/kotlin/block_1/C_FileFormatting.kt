package org.example.block_1

fun formatFile() {
    val numberOfStrings = readln().toInt()

    var numberOfPresses = 0L

    repeat(numberOfStrings) {
        val numberOfSpaces = readln().toInt()

        val tabPresses = (numberOfSpaces / 4)

        numberOfPresses += tabPresses

        if (numberOfSpaces % 4 == 1) {
            numberOfPresses++
        }

        if (numberOfSpaces % 4 == 2 || numberOfSpaces % 4 == 3) {
            numberOfPresses += 2
        }

    }

    println(numberOfPresses)
}