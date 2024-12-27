package com.example.calculatoroftime

import androidx.core.text.isDigitsOnly

class Operation(private val firstTime: String, private val secondTime: String) {

    fun sumTimes() = secToTime(timeToSec(firstTime) + timeToSec(secondTime))
    fun difTimes() = secToTime(timeToSec(firstTime) - timeToSec(secondTime))


    private fun timeToSec(time: String): Int {
        var sumSec = 0
        val str = time.substringAfter('h')

        if (time.substringBefore('h').isDigitsOnly())
            sumSec += (time.substringBefore('h').toInt() * 3600)

        if (str.substringBefore('m').isDigitsOnly())
            sumSec += (str.substringBefore('m').toInt() * 60)

        if (str.substringAfter('m').substringBefore('s').isDigitsOnly())
            sumSec += str.substringAfter('m').substringBefore('s').toInt()

        return sumSec
    }

    private fun secToTime(sec: Int): String {

        var h = "0h"
        var m = "0m"
        var s = "0s"

        h = "${(sec / 3600).toString()}h"
        m = "${((sec % 3600) / 60).toString()}m"
        s = "${((sec % 3600) % 60).toString()}s"

        return when {
            h == "0h" && m == "0m" -> s
            h == "0h" && m != "0m" -> m + s
            else -> h + m + s
        }
    }

}