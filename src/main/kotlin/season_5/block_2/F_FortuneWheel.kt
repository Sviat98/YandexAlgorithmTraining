package org.example.season_5.block_2

fun fortuneWheel() {
    val sectorsAmount = readln().toInt()

    val sectors = readln().split(' ').map { it.toInt() }

    val (minTargetVelocity, maxTargetVelocity, decreaseVelocity) = readln().split(' ').map { it.toInt() }

    val begin = System.currentTimeMillis()

    val sortedSectors = sectors.sortedDescending()

    val maxSector = sortedSectors[0]

    var answer: Int

    val minSectorsToReach = if (minTargetVelocity%decreaseVelocity==0) minTargetVelocity/decreaseVelocity-1 else minTargetVelocity/decreaseVelocity

    val maxSectorsToReach = if (maxTargetVelocity%decreaseVelocity==0) maxTargetVelocity/decreaseVelocity -1 else maxTargetVelocity/decreaseVelocity

    if(maxSectorsToReach-minSectorsToReach>=sectorsAmount){
        answer = maxSector
    }else{
        val indexesToReachRight = (minSectorsToReach..maxSectorsToReach).map { it % sectorsAmount }
        val indexesToReachLeft = indexesToReachRight.map { sectorsAmount-it }

        val allIndexes = indexesToReachLeft.union(indexesToReachRight)

        val possibleMaxSector = sectors.filterIndexed{index, sector -> index in allIndexes }.max()

        answer = possibleMaxSector
    }

    println(answer)

    val end = System.currentTimeMillis()

    println("Execution time is ${end - begin} ms")
}