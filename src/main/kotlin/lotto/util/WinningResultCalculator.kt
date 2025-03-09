package lotto.util

import lotto.model.Lotto
import lotto.model.LottoTickets

class WinningResultCalculator(private val winnerNumber: Lotto, private val bonusNumber: Int, private val lottoTickets: LottoTickets) {
    private val result = mutableMapOf(3 to 0, 4 to 0, 5 to 0, 6 to 0, 123 to 0)
    fun calculcateResult(): Map<Int, Int> {
        lottoTickets.tickets.forEach({
            val sameNumberCount = it.countSameNumbers(winnerNumber)
            if (sameNumberCount == 5) {
                bonusResult(it)
            }
            else {
                countResult(sameNumberCount)
            }
        })
        return result
    }

    private fun bonusResult(lotto: Lotto) : Map<Int, Int> {
        if (lotto.checkBonusNumber(bonusNumber)) {
            result[123] = result[123]!!.plus(1)
            println(lotto)
            return result
        }
        result[5] = result[5]!!.plus(1)
        return result
    }

    private fun countResult(key: Int) : Map<Int, Int> {
        if(result.containsKey(key)) {
            result[key] = result[key]!!.plus(1)
            return result
        }
        result[key] = 1
        return result
    }

}