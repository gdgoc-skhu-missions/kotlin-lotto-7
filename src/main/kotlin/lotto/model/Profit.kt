package lotto.model

import kotlin.math.round

class Profit(private val purchase: Purchase, private val winningResult: Map<Int, Int>) {

    fun calculateWinningAmount(): Int {
        val winningTable = mapOf<Int, Int>(3 to 5000, 4 to 50000, 5 to 1500000, 123 to 30000000, 6 to 2000000000)
        var winningAmount = 0
        winningTable.forEach { key, value
            -> winningAmount += winningResult[key]!!.toInt() * value
        }
        return winningAmount
    }

    fun calculateProfit(): Double {
        val winningAmount = calculateWinningAmount().toDouble()
        return round(winningAmount / purchase.amount * 1000) /10
    }
}