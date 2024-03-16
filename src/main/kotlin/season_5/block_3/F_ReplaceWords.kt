package org.example.season_5.block_3

fun replaceWords() {

    var wordsToReplace = readln().trim().split(' ')

    val initialText = readln().trim()

    val wordsInText = initialText.split(' ').toMutableList()

    val wordsToReplaceExcluded = mutableListOf<String>()

    wordsToReplace.forEach { wordToReplace ->

        val anotherWordToReplace =
            wordsToReplace.find { it != wordToReplace && wordToReplace.startsWith(it) && it.length < wordToReplace.length }

        anotherWordToReplace?.let {
            wordsToReplaceExcluded.add(wordToReplace)
        }

    }

    wordsToReplace = wordsToReplace.filterNot { it in wordsToReplaceExcluded }

    val wordsToReplaceMap = wordsToReplace.groupBy { it[0] }

    wordsInText.forEachIndexed { index, wordInText ->

        val wordsToReplaceOptions = wordsToReplaceMap[wordInText[0]]

        wordsToReplaceOptions?.forEach { wordToReplace ->
            if (wordInText.startsWith(wordToReplace)) {
                wordsInText[index] = wordToReplace
            }
        }
    }

    val finalText = wordsInText.joinToString(" ")

    println(finalText)
}