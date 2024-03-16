import java.util.*

fun ambitiousSnail() {
    val numberOfBerries = readln().toInt()

    val berries = mutableListOf<Triple<Int, Int, Int>>()

    var lastPositiveBerryIndex = -1

    repeat(numberOfBerries) {

        val berryParams = readln().split(' ').map { it.toInt() }

        val berryStrength = berryParams[0] - berryParams[1]

        val berryMaxHeight = berryParams[0]

        val berryNumber = it + 1

        val berry = Triple(berryNumber, berryStrength, berryMaxHeight)

        berries.add(berry)
    }

    val (positiveBerries, negativeBerries) = berries.partition { it.second > 0 }

    if (negativeBerries.isNotEmpty()) {

        val maxHeightForBerry = negativeBerries.maxBy { it.third }.third

        val berryToReachMaxHeight = negativeBerries.filter { it.third == maxHeightForBerry }.minBy { it.second }

        val berryToReachMaxHeightIndex = negativeBerries.indexOf(berryToReachMaxHeight)

        Collections.swap(negativeBerries, 0, berryToReachMaxHeightIndex)
    }

    var maxHeight = 0L

    val positiveBerrySum = positiveBerries.sumOf { it.second.toLong() }

    positiveBerries.forEachIndexed { index, berry ->
        val maxHeightIfLast = positiveBerrySum - berry.second + berry.third

        if (maxHeightIfLast > maxHeight) {
            maxHeight = maxHeightIfLast
            lastPositiveBerryIndex = index
        }
    }

    if (lastPositiveBerryIndex != -1) {
        Collections.swap(positiveBerries, lastPositiveBerryIndex, positiveBerries.size - 1)
    }

    if (negativeBerries.isNotEmpty()) {
        val maxHeightWithFirstNegative = positiveBerrySum + negativeBerries[0].third

        if (maxHeightWithFirstNegative > maxHeight) {
            maxHeight = maxHeightWithFirstNegative
        }
    }

    val sortedBerries = positiveBerries + negativeBerries


    println(maxHeight)
    println(sortedBerries.map { it.first }.joinToString(" "))
}
