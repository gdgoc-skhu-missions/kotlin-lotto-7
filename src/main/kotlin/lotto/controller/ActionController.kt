package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoTickets
import lotto.model.Profit
import lotto.model.Purchase
import lotto.util.NumberValidator
import lotto.util.WinningResultCalculator
import lotto.view.Input
import lotto.view.Output

object ActionController {
    fun runLotto() {
        val lottoTickets = LottoTickets(getPurchase(), ArrayList()).getLottoTickets()
        getLottoTickets(lottoTickets)
        val winnerNumber = getWinnerNumber()
        val bonusNumber = getBonusNumber()
        NumberValidator.checkSameNumberBonus(winnerNumber, bonusNumber)
        val result = getWinnerResult(lottoTickets, winnerNumber, bonusNumber)
        getProfit(lottoTickets, result)
    }

    private fun getPurchase(): Int {
        Output.printPurchaseMessage()
        val getPurchase = Input.getPurchase()
        NumberValidator.purchaseValidator(getPurchase)
        val purchase = Purchase(getPurchase.toInt())
        val purcharseCount = purchase.getPurchaseCount()
        Output.printTicketNumberMessage(purcharseCount)
        return purcharseCount
    }

    private fun getLottoTickets(lottoTickets: LottoTickets) {
        Output.printTickets(lottoTickets.tickets)
    }

    private fun getWinnerNumber(): Lotto{
        Output.printWineerNumberMessage()
        val getWinnerNumber = Input.getWinnerNumber()
        NumberValidator.winningNumberValidator(getWinnerNumber)
        val winnerNumber =  Lotto(getWinnerNumber.map { it.toInt() })
        return winnerNumber
    }

    private fun getBonusNumber(): Int{
        Output.printBonusNumberMessage()
        val bonusNumber = Input.getBonusNumber()
        NumberValidator.bonusNumberValidator(bonusNumber)
        return bonusNumber.toInt()
    }

    private fun getWinnerResult(lottoTickets: LottoTickets, winnerNumber: Lotto, bonusNumber: Int): Map<Int, Int> {
        val winningResultCalculator = WinningResultCalculator(winnerNumber, bonusNumber, lottoTickets)
        val result = winningResultCalculator.calculcateResult()
        Output.printWinningResultMessage()
        Output.printWinningResult(result)
        return result
    }

    private fun getProfit(lottoTickets: LottoTickets, result: Map<Int, Int>) {
        val purchase = Purchase(lottoTickets.purchaseCount * 1000)
        val profit = Profit(purchase, result)
        Output.printProfitMessage(profit.calculateProfit())
    }
}