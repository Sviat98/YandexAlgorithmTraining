package org.example.season_5.block_3

fun playlist() {
    val numOfMembers = readln().toInt()

    val begin = System.currentTimeMillis()

    val favSongsByAllMembers = mutableSetOf<String>()

    repeat(numOfMembers) {
        val favSongsAmount = readln().toInt()

        val memberFavSongs = readln().split(' ').toSet()

        if(it==0){
            favSongsByAllMembers.addAll(memberFavSongs)
        }

        val favSongsToDelete = favSongsByAllMembers.filterNot { it in memberFavSongs }

        favSongsByAllMembers.removeAll(favSongsToDelete)
    }

    val inputEnd = System.currentTimeMillis()

    println(favSongsByAllMembers.size)
    println(favSongsByAllMembers.sorted().joinToString(" "))

    val end = System.currentTimeMillis()

    println("Execution time is ${end-begin} ms")
}