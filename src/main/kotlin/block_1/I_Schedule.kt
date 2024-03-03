package org.example.block_1

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month

fun schedule() {

    val localDate = LocalDate.now()

    localDate.dayOfYear

    localDate.dayOfWeek

    val numberOfBankHolidays = readln().toInt()

    val dayOfWeekMap = mutableMapOf<DayOfWeek, Int>()

    val minDaysInYear = 52

    DayOfWeek.entries.forEach {
        dayOfWeekMap[it] = minDaysInYear
    }

    val bankHolidays = mutableListOf<String>()

    val year = readln().toInt()

    repeat(numberOfBankHolidays) {
        val bankHoliday = readln()

        bankHolidays.add(bankHoliday)
    }

    val firstDayOfWeekInYear = readln()

    val firstDayOfWeek = DayOfWeek.valueOf(firstDayOfWeekInYear.uppercase())

    val secondDayOfWeek = DayOfWeek.of((firstDayOfWeek.value % 7) + 1)

    dayOfWeekMap[firstDayOfWeek] = minDaysInYear + 1

    val leapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)

    if (leapYear) {
        dayOfWeekMap[secondDayOfWeek] = minDaysInYear + 1
    }

    bankHolidays.forEach { bankHoliday ->
        val (day, month) = bankHoliday.split(' ')
        val localDate = LocalDate.of(year, Month.valueOf(month.uppercase()), day.toInt())

        val dayOfWeek = localDate.dayOfWeek

        dayOfWeekMap.entries.forEach {
            if (it.key != dayOfWeek) {
                it.setValue(it.value + 1)
            }
        }
    }

    val maxWeekend =
        dayOfWeekMap.maxBy { it.value }.key.name

    val minWeekend =
        dayOfWeekMap.minBy { it.value }.key.name

    println(
        "${maxWeekend[0] + maxWeekend.substring(1).lowercase()} ${
            minWeekend[0] + minWeekend.substring(1).lowercase()
        }"
    )
}