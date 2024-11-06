package org.example.season_6.block_1

fun raftAndSwimmer(){

    val raftSouthWestX = readln().toInt()
    val raftSouthWestY = readln().toInt()

    val raftNorthEastX = readln().toInt()
    val raftNorthEastY = readln().toInt()

    val swimmerX = readln().toInt()
    val swimmerY = readln().toInt()

    var result = ""

    when{
        (swimmerX <= raftSouthWestX) -> {
            result = if (swimmerY<=raftSouthWestY){
                "SW"
            }else if (swimmerY>=raftNorthEastY){
                "NW"
            }else{
                "W"
            }
        }
        (swimmerX >= raftNorthEastX) -> {
            result = if (swimmerY<=raftSouthWestY){
                "SE"
            }else if (swimmerY>=raftNorthEastY){
                "NE"
            }else{
                "E"
            }
        }
        else ->{
            result = if (swimmerY<=raftSouthWestY){
                "S"
            }else{
                "N"
            }
        }
    }

    println(result)
}