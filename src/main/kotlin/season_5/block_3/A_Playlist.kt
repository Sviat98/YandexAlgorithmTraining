package org.example.season_5.block_3

import java.io.PrintWriter

fun playlist() {
    val numOfMembers = readln().toInt()

    val begin = System.currentTimeMillis()

    val favSongsByAllMembers = mutableSetOf<String>()

    repeat(numOfMembers) {
        val favSongsAmount = readln().toInt()

        val memberFavSongs = readln().split(' ').toSet()

        if (it == 0) {
            favSongsByAllMembers.addAll(memberFavSongs)
        }

        val favSongsToDelete = favSongsByAllMembers.filterNot { favSong -> favSong in memberFavSongs }

        favSongsByAllMembers.removeAll(favSongsToDelete.toSet())
    }

    val inputEnd = System.currentTimeMillis()

    println("Input time is ${inputEnd - begin} ms")


//    val printWriter1 = PrintWriter(favSongsByAllMembers.size.toString())
//
//    printWriter1.println()
//
//    val printWriter2 = PrintWriter(favSongsByAllMembers.sorted().joinToString(" "))
//
//    printWriter2.println()

    println(favSongsByAllMembers.size)
    println(favSongsByAllMembers.sorted().joinToString(" "))

    val end = System.currentTimeMillis()

    println("Execution time is ${end - begin} ms")
}