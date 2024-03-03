package org.example.block_1

fun championsLeaguePlayOff() {
    val (firstTeamFirstMatch, secondTeamFirstMatch) = readln().split(':').map { it.toInt() }
    val (firstTeamSecondMatch, secondTeamSecondMatch) = readln().split(':').map { it.toInt() }

    val isFirstTeamFirstMatchHome =
        readln().toInt() == 1 // 1- команда первый матч играла дома, а сейчас играет на выезде, 2- команда первый матч играла на выезде , а сейчас играет  дома

    val firstTeamAggregate = firstTeamFirstMatch + firstTeamSecondMatch

    val secondTeamAggregate = secondTeamFirstMatch + secondTeamSecondMatch

    val firstTeamNeedToScoreToWin = when {
        (firstTeamAggregate > secondTeamAggregate) -> 0 //они и так выигрывают
        else -> {
            var goalsToScore = secondTeamAggregate - firstTeamAggregate //нужно для того, чтобы сравнять счет по сумме

            val awayGoalDiff =
                if (isFirstTeamFirstMatchHome) firstTeamSecondMatch + goalsToScore - secondTeamFirstMatch else firstTeamFirstMatch - secondTeamSecondMatch

            if (awayGoalDiff <= 0){
                goalsToScore++
            }

            goalsToScore
        }
    }

    println(firstTeamNeedToScoreToWin)
}