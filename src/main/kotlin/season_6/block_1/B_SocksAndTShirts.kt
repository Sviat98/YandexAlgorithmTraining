package org.example.season_6.block_1

fun socksAndTShirts() {
    val blueTShirts = readln().toInt()
    val redTShirts = readln().toInt()

    val blueSocks = readln().toInt()
    val redSocks = readln().toInt()

    var minTShirtsToRetrieve = 0
    var minSocksToRetrieve = 0

    if (blueTShirts == 0) {
        minTShirtsToRetrieve = 1
        minSocksToRetrieve = blueSocks + 1
    } else if (redTShirts == 0) {
        minTShirtsToRetrieve = 1
        minSocksToRetrieve = redSocks + 1
    } else if (blueSocks == 0) {
        minTShirtsToRetrieve = blueTShirts + 1
        minSocksToRetrieve = 1
    } else if (redSocks == 0) {
        minTShirtsToRetrieve = redTShirts + 1
        minSocksToRetrieve = 1
    } else {
        val maxTShirtsOfOneColor = blueTShirts.coerceAtLeast(redTShirts)
        val maxSocksOfOneColor = blueSocks.coerceAtLeast(redSocks)
        val minFromMaxValues = maxSocksOfOneColor.coerceAtMost(maxTShirtsOfOneColor)

        val sumWithMaxValue = minFromMaxValues+2
        var sumWithAvgValue = 0

        when(minFromMaxValues){
            blueTShirts->{
                sumWithAvgValue = redTShirts+redSocks+2

                if(sumWithAvgValue<sumWithMaxValue){
                    minTShirtsToRetrieve = redTShirts+1
                    minSocksToRetrieve = redSocks+1
                }else{
                    minTShirtsToRetrieve = blueTShirts+1
                    minSocksToRetrieve = 1
                }
            }
            redTShirts->{
                sumWithAvgValue = blueTShirts+blueSocks+2

                if(sumWithAvgValue<sumWithMaxValue){
                    minTShirtsToRetrieve = blueTShirts+1
                    minSocksToRetrieve = blueSocks+1
                }else{
                    minTShirtsToRetrieve = redTShirts+1
                    minSocksToRetrieve = 1
                }
            }
            blueSocks->{
                sumWithAvgValue = redTShirts+redSocks+2

                if(sumWithAvgValue<sumWithMaxValue){
                    minTShirtsToRetrieve = redTShirts+1
                    minSocksToRetrieve = redSocks+1
                }else{
                    minTShirtsToRetrieve = 1
                    minSocksToRetrieve = blueSocks+1
                }
            }
            redSocks->{
                sumWithAvgValue = blueTShirts+blueSocks+2

                if(sumWithAvgValue<sumWithMaxValue){
                    minTShirtsToRetrieve = blueTShirts+1
                    minSocksToRetrieve = blueSocks+1
                }else{
                    minTShirtsToRetrieve = 1
                    minSocksToRetrieve = redSocks+1
                }
            }
        }
    }

    println("$minTShirtsToRetrieve $minSocksToRetrieve")
}