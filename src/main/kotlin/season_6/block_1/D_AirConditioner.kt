package org.example.season_6.block_1

fun airConditioner(){
    val input = readln().split(' ')

    val roomTemperature = input[0].toInt()
    val airConditionerTemperature = input[1].toInt()
    val airConditionerRegime = input[2]

    var roomTemperatureIn1Hour = -51

    when(airConditionerRegime){
        "fan" -> {
            roomTemperatureIn1Hour = roomTemperature
        }
        "auto"-> {
            roomTemperatureIn1Hour = airConditionerTemperature
        }
        "heat"-> {
            roomTemperatureIn1Hour = if(roomTemperature<airConditionerTemperature){
                airConditionerTemperature
            }else{
                roomTemperature
            }
        }
        "freeze" ->{
            roomTemperatureIn1Hour = if(roomTemperature>airConditionerTemperature){
                airConditionerTemperature
            }else{
                roomTemperature
            }
        }
    }

    println(roomTemperatureIn1Hour)

}