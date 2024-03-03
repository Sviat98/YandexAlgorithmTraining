package org.example.block_1

fun destroyBarracks() {
    var amountOfMySoldiers = readln().toInt()
    val barracksHealth = readln().toInt()
    val amountOfOpponentSoldiersPerRound = readln().toInt()

    var amountOfOpponentSoldiers = 0

    var myRemainingSoldiers = 0

//    amountOfMySoldiers = 10
//
//    barracksHealth = 11

   // myRemainingSoldiers = amountOfMySoldiers - barracksHealth.coerceAtMost(amountOfMySoldiers)

    //println("myRemainingSoldiers $myRemainingSoldiers")

    var opponentPoints = barracksHealth

    var currentRound = 0
    //условия начала каждого раунда
    // - у меня должны быть солдаты
    // - у соперника должны быть солдаты либо жива казарма
    while (amountOfMySoldiers > 0 && opponentPoints > 0) {

        myRemainingSoldiers = amountOfMySoldiers - opponentPoints.coerceAtMost(amountOfMySoldiers)
        // сколько людей останется после штурма казармы

        //println(myRemainingSoldiers)

        opponentPoints -= amountOfMySoldiers.coerceAtMost(opponentPoints)

        amountOfMySoldiers-=amountOfOpponentSoldiers.coerceAtMost(amountOfMySoldiers)

        if (opponentPoints<=amountOfOpponentSoldiersPerRound) {
            amountOfOpponentSoldiers += amountOfOpponentSoldiersPerRound//казарма производит новых солдат
            opponentPoints+=amountOfOpponentSoldiers
        }

        currentRound++

    }

    if (amountOfMySoldiers == 0) {
        currentRound = -1
    }

    println(currentRound)

}