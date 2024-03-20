package org.example.season_5.block_3

fun football() {
    val matchRegex = Regex("\"([A-Z]|[a-z]|\\s)+\"\\s-\\s\"([A-Z]|[a-z]|\\s)+\"\\s(\\d){1,2}:(\\d){1,2}")

    val teamRegex = Regex("\"([A-Z]|[a-z]|\\s)+\"")

    val scoreRegex = Regex("(\\d){1,2}:(\\d){1,2}")

    val goalRegex = Regex("([A-Z]|[a-z]|\\s)+\\s(\\d){1,2}'")

    val scorerRegex = Regex("([A-Z]|[a-z]|\\s)+")

    val scoreMinuteRegex = Regex("(\\d){1,2}'")

    val teamsMap = mutableMapOf<String, Pair<Int, MutableSet<String>>>()

    val playersMap = mutableMapOf<String, Pair<Int, MutableList<Int>>>()

    while (true) {
        val footballInfo = readln().trim()

//        println(footballInfo)

        when {
            footballInfo.matches(matchRegex) -> {
                var firstMinuteToScore = 90

                var firstTeamFirstScorer = Pair("", 0)
                var secondTeamFirstScorer = Pair("", 0)

                val teams = teamRegex.findAll(footballInfo).map { it.value.substring(1..<it.value.length - 1) }

                val firstTeam = teams.elementAt(0)

                val firstTeamInfo = teamsMap[firstTeam] ?: Pair(0, mutableSetOf())

                val firstTeamGamesAmount = firstTeamInfo.first + 1

                val firstTeamSquad = firstTeamInfo.second


                val secondTeam = teams.elementAt(1)

                val secondTeamInfo = teamsMap[firstTeam] ?: Pair(0, mutableSetOf())

                val secondTeamGamesAmount = secondTeamInfo.first + 1

                val secondTeamSquad = secondTeamInfo.second

                val (firstTeamScore, secondTeamScore) = scoreRegex.find(footballInfo)!!.value.split(':')
                    .map { it.toInt() }

                repeat(firstTeamScore) {
                    val goal = readln()

                    val scorer = scorerRegex.find(goal)!!.value.trim()

                    firstTeamSquad.add(scorer)

                    val scorerInfo = playersMap[scorer] ?: Pair(0, mutableListOf())

                    val scoringMinute = scoreMinuteRegex.find(goal)!!.value.trim().dropLast(1).toInt()

                    val scoringMinutes = scorerInfo.second

                    scoringMinutes.add(scoringMinute)

                    playersMap[scorer] = Pair(scorerInfo.first, scoringMinutes)

                    if (it == 0) {
                        firstTeamFirstScorer = Pair(scorer, scoringMinute)
                    }
                }

                repeat(secondTeamScore) {
                    val goal = readln()

                    val scorer = scorerRegex.find(goal)!!.value.trim()

                    secondTeamSquad.add(scorer)

                    val scorerInfo = playersMap[scorer] ?: Pair(0, mutableListOf())

                    val scoringMinute = scoreMinuteRegex.find(goal)!!.value.trim().dropLast(1).toInt()

                    val scoringMinutes = scorerInfo.second

                    scoringMinutes.add(scoringMinute)

                    playersMap[scorer] = Pair(scorerInfo.first, scoringMinutes)

                    if (it == 0) {
                        secondTeamFirstScorer = Pair(scorer, scoringMinute)
                    }
                }

                val firstPlayerToScoreInMatch =
                    listOf(firstTeamFirstScorer, secondTeamFirstScorer).minBy { it.second }.first

                val firstPlayerToScoreInMatchInfo = playersMap[firstPlayerToScoreInMatch] ?: Pair(0, mutableListOf())

                val playerFirstToScoreTimes =
                    firstPlayerToScoreInMatchInfo.first + 1 //количество раз, когда игрок открывал счет в матче

                playersMap[firstPlayerToScoreInMatch] =
                    Pair(playerFirstToScoreTimes, firstPlayerToScoreInMatchInfo.second)

                teamsMap[firstTeam] = Pair(firstTeamGamesAmount, firstTeamSquad)

                teamsMap[secondTeam] = Pair(secondTeamGamesAmount, secondTeamSquad)

            }
            footballInfo.startsWith("Total goals for") -> {
                val team = teamRegex.find(footballInfo)!!.value.trim().drop(1).dropLast(1)

                var totalTeamGoals = 0

                val teamScorers = teamsMap[team]?.second

                teamScorers?.forEach { teamScorer ->
                    val scoringMinutesCount = playersMap[teamScorer]?.second?.size ?: 0

                    totalTeamGoals += scoringMinutesCount
                }
                println(totalTeamGoals)
            }
            footballInfo.startsWith("Total goals by") -> {
                val player = footballInfo.trim().substring(16, footballInfo.length)

                val playerTotalGoals = teamsMap[player]?.second?.size ?: 0

                println(playerTotalGoals)
            }
        }
    }

}