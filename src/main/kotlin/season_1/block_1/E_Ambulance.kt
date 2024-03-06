package org.example.season_1.block_1

fun ambulance() {
    val (firstFlatNumber, numberOfFloors, secondFlatNumber, secondFlatSection, secondFlatFloor) = readln().split(' ')
        .map { it.toInt() }

    val flatsOnPrevFloors = (secondFlatSection - 1) * numberOfFloors + secondFlatFloor - 1

    val flatsPerFloor = secondFlatNumber / flatsOnPrevFloors

    val firstFlatFloorNumberWithoutSection =
        firstFlatNumber / flatsPerFloor + 1// если этажи можно сложаить, без учета номеров подъездов

    val firstFlatSection = firstFlatFloorNumberWithoutSection / numberOfFloors + 1

    val firstFlatFloor = firstFlatFloorNumberWithoutSection % numberOfFloors

    println("$firstFlatSection $firstFlatFloor")
}