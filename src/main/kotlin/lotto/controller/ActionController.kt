package lotto.controller

import lotto.controller.TiketsController.getPurchaseNumber
import lotto.model.LottoTickets
import lotto.view.Input

import lotto.view.Output

object ActionController {
    fun startLotto(): Int {

        Output.printPurchase()
        val purchase = Input.getPurchase()


        Output.printTicketNumber(getPurchaseNumber(purchase))

        return purchase
    }

    fun getLottoTicketsResult() {
        val lottoTickets = LottoTickets(getPurchaseNumber(startLotto()))

        Output.printTickets(lottoTickets.getLottoTicket())

    }

}