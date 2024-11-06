package org.example.season_6.block_2

fun toDoList(){
    val (tasksAmount, taskDifference)  = readln().split(' ').map { it.toInt() }

    val taskList = readln().split(' ').map { it.toInt() }.sorted()

    var daysToComplete = 1

    var right = 0

  for (left in 0 until taskList.size){
        while (right< taskList.size && taskList[right]-taskList[left]<=taskDifference){
            right++
        }
        val rightElement = if (right==taskList.size) "No" else taskList[right]
        println("${taskList[left]} $rightElement")
            val currentDaysToComplete = right-left
            if (currentDaysToComplete>daysToComplete){
                daysToComplete = currentDaysToComplete
            }
    }

    println(daysToComplete)
}