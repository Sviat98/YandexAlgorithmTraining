package org.example.block_1

fun paintTree() {

    val (firstTreePoint, firstTreeDist) = readln().split(' ').map { it.toInt() }
    val (secondTreePoint, secondTreeDist) = readln().split(' ').map { it.toInt() }

    var treesToExclude = 0
    val firstTreeMin = firstTreePoint-firstTreeDist
    val firstTreeMax = firstTreePoint+firstTreeDist

    val secondTreeMin = secondTreePoint-secondTreeDist
    val secondTreeMax = secondTreePoint+secondTreeDist

    val minTreePointsSorted = listOf(firstTreeMin,secondTreeMin).sorted()
    val maxTreePointsSorted = listOf(firstTreeMax,secondTreeMax).sorted()

    val minTreePoint = minTreePointsSorted[0]
    val maxTreePoint = maxTreePointsSorted[1]

    val treesBetweenMinAndMax = maxTreePoint-minTreePoint+1

    if(minTreePointsSorted[1]-maxTreePointsSorted[0]>1){
        treesToExclude = minTreePointsSorted[1]-maxTreePointsSorted[0]-1
    }

    val treesToPaint = treesBetweenMinAndMax-treesToExclude
    println(treesToPaint)
}