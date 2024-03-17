package org.example.season_5.block_2

fun fortuneWheel(){
    val sectorsAmount = readln().toInt()

    val sectors =  readln().split(' ').map { it.toInt() }

    val (minVelocity, maxVelocity, decreaseVelocity) = readln().split(' ').map { it.toInt() }

    var maxSector = 0

    val sortedSectors = sectors.sortedDescending()

    val startSector = sectors[0]

    val velocityRange = minVelocity..maxVelocity

    for(index in sortedSectors.indices){
        val sector = sortedSectors[index]

        val originalIndex = sectors.indexOf(sector)

        val minSectorsToReachLeft = sectorsAmount-originalIndex

        val minSectorsToReachRight = originalIndex

        val minVelocityToReachLeft = decreaseVelocity*minSectorsToReachLeft+1

        val maxVelocityToReachLeft = decreaseVelocity*minSectorsToReachLeft+1


        val minVelocityToReachRight = decreaseVelocity*minSectorsToReachRight+1

        val maxVelocityToReachRight = decreaseVelocity*minSectorsToReachRight+decreaseVelocity- 1

        if(maxVelocityToReachLeft<minVelocity){

        }

    }
}