package org.example.season_5.block_3

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

fun football() {
    val matchRegex = Regex("\"([A-Z]|[a-z]|\\s)+\"\\s-\\s\"([A-Z]|[a-z]|\\s)+\"\\s(\\d){1,2}:(\\d){1,2}")

    val teamRegex = Regex("\"([A-Z]|[a-z]|\\s)+\"")

    val output = mutableListOf<String>()

    val scoreRegex = Regex("(\\d){1,2}:(\\d){1,2}")

    val scorerRegex = Regex("([A-Z]|[a-z]|\\s)+")

    val scoreMinuteRegex = Regex("(\\d){1,2}")

    val teamsMap = mutableMapOf<String, Pair<Int, MutableSet<String>>>()

    val playersMap = mutableMapOf<String, Pair<Int, MutableList<Int>>>()

    val footballFacts =
        File("input.txt").inputStream().readBytes().toString(Charsets.UTF_8).split("\r\n").filter { it.isNotEmpty() }

    footballFacts.forEachIndexed { index, footballInfo ->
        when {
            footballInfo.matches(matchRegex) -> {
                var firstTeamFirstScorer = Pair("", 0)
                var secondTeamFirstScorer = Pair("", 0)

                val teams = teamRegex.findAll(footballInfo).map { it.value.substring(1..<it.value.length - 1) }

                val firstTeam = teams.elementAt(0)

                val firstTeamInfo = teamsMap[firstTeam] ?: Pair(0, mutableSetOf())

                val firstTeamGamesAmount = firstTeamInfo.first + 1

                val firstTeamSquad = firstTeamInfo.second


                val secondTeam = teams.elementAt(1)

                val secondTeamInfo = teamsMap[secondTeam] ?: Pair(0, mutableSetOf())

                val secondTeamGamesAmount = secondTeamInfo.first + 1

                val secondTeamSquad = secondTeamInfo.second

                val (firstTeamScore, secondTeamScore) = scoreRegex.find(footballInfo)!!.value.split(':')
                    .map { it.toInt() }

                repeat(firstTeamScore) { goalIndex ->
                    val goal = footballFacts[index + goalIndex + 1]

                    val scorer = scorerRegex.find(goal)!!.value.trim()

                    firstTeamSquad.add(scorer)

                    val scorerInfo = playersMap[scorer] ?: Pair(0, mutableListOf())

                    val scoringMinute = scoreMinuteRegex.find(goal)!!.value.trim().toInt()

                    val scoringMinutes = scorerInfo.second

                    scoringMinutes.add(scoringMinute)

                    playersMap[scorer] = Pair(scorerInfo.first, scoringMinutes)

                    if (goalIndex == 0) {
                        firstTeamFirstScorer = Pair(scorer, scoringMinute)
                    }
                }
                repeat(secondTeamScore) { goalIndex ->
                    val goal = footballFacts[index + goalIndex + firstTeamScore + 1]

                    val scorer = scorerRegex.find(goal)!!.value.trim()

                    secondTeamSquad.add(scorer)

                    val scorerInfo = playersMap[scorer] ?: Pair(0, mutableListOf())

                    val scoringMinute = scoreMinuteRegex.find(goal)!!.value.trim().toInt()

                    val scoringMinutes = scorerInfo.second

                    scoringMinutes.add(scoringMinute)

                    playersMap[scorer] = Pair(scorerInfo.first, scoringMinutes)

                    if (goalIndex == 0) {
                        secondTeamFirstScorer = Pair(scorer, scoringMinute)
                    }
                }

                val firstPlayerToScoreInMatch =
                    listOf(firstTeamFirstScorer, secondTeamFirstScorer).minBy { it.second }.first

                if(firstPlayerToScoreInMatch.isNotEmpty()){
                    val firstPlayerToScoreInMatchInfo = playersMap[firstPlayerToScoreInMatch] ?: Pair(0, mutableListOf())

                    val playerFirstToScoreTimes =
                        firstPlayerToScoreInMatchInfo.first + 1 //количество раз, когда игрок открывал счет в матче

                    playersMap[firstPlayerToScoreInMatch] =
                        Pair(playerFirstToScoreTimes, firstPlayerToScoreInMatchInfo.second)
                }
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
                output.add(totalTeamGoals.toString())
            }

            footballInfo.startsWith("Total goals by") -> {
                val player = footballInfo.substring(16, footballInfo.length)

                val playerTotalGoals = teamsMap[player]?.second?.size ?: 0

                output.add(playerTotalGoals.toString())
            }
            footballInfo.startsWith("Mean goals per game for") -> {
                val team = teamRegex.find(footballInfo)!!.value.trim().drop(1).dropLast(1)

                var totalTeamGoals = 0

                val teamTotalMatches = teamsMap[team]?.first ?: 0

                val teamScorers = teamsMap[team]?.second

                teamScorers?.forEach { teamScorer ->
                    val scoringMinutesCount = playersMap[teamScorer]?.second?.size ?: 0

                    totalTeamGoals += scoringMinutesCount
                }

                val teamGoalsPerGame = (totalTeamGoals / teamTotalMatches).toDouble()

                output.add(teamGoalsPerGame.toString())
            }
            footballInfo.startsWith("Mean goals per game by") -> {
                val player = footballInfo.substring(23, footballInfo.length)

                val totalPlayerMatches =
                    teamsMap.filterValues { player in it.second }.entries.map { it.value.first }.firstOrNull() ?: 0

                val playerTotalGoals = playersMap[player]?.second?.size ?: 0

                val playerGoalsPerGame =
                    if (totalPlayerMatches == 0) 0.0 else playerTotalGoals.toDouble() / totalPlayerMatches

                output.add(playerGoalsPerGame.toString())
            }

            footballInfo.matches(Regex("Goals on minute $scoreMinuteRegex by $scorerRegex")) -> {
                val scoringMinute = scoreMinuteRegex.find(footballInfo)!!.value.toInt()

                val scorer = footballInfo.substring(footballInfo.indexOf(" by ") + 4)

                val goalsOnThatMinuteScored = playersMap[scorer]?.second?.filter { it == scoringMinute }?.size ?: 0

                output.add(goalsOnThatMinuteScored.toString())
            }

            footballInfo.matches(Regex("Goals on first $scoreMinuteRegex minutes by $scorerRegex")) -> {
                val scoringMinute = scoreMinuteRegex.find(footballInfo)!!.value.toInt()

                val scorer = footballInfo.substring(footballInfo.indexOf(" by ") + 4)

                val goalsOnFirstMinutesScored = playersMap[scorer]?.second?.filter { it <= scoringMinute }?.size ?: 0

                output.add(goalsOnFirstMinutesScored.toString())
            }

            footballInfo.matches(Regex("Goals on last $scoreMinuteRegex minutes by $scorerRegex")) -> {
                val scoringMinute = 91 - scoreMinuteRegex.find(footballInfo)!!.value.toInt()

                val scorer = footballInfo.substring(footballInfo.indexOf(" by ") + 4)

                val goalsOnLastMinutesScored = playersMap[scorer]?.second?.filter { it >= scoringMinute }?.size ?: 0

                output.add(goalsOnLastMinutesScored.toString())
            }

            footballInfo.startsWith("Score opens by") -> {
                val teamOrScorer = footballInfo.substring(15)

                var scoreOpenAmount = 0

                if (teamOrScorer[0] == '"') {//team

                    val team = teamOrScorer.drop(1).dropLast(1)
                    val teamSquad = teamsMap[team]?.second

                    teamSquad?.forEach { player ->
                        scoreOpenAmount += playersMap[player]?.first ?: 0
                    }

                } else {//scorer
                    val scorer = teamOrScorer

                    scoreOpenAmount = playersMap[scorer]?.first ?: 0
                }
                output.add(scoreOpenAmount.toString())
            }
            else -> Unit
        }
    }

    val outputStream = BufferedWriter(FileWriter("output.txt"))
    outputStream.write(output.joinToString("\n"))
    outputStream.flush()
}