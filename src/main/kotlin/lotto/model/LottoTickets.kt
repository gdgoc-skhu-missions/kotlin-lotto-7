package lotto.model

import lotto.controller.TiketsController


class LottoTickets(val ticketNumber: Int) {
    var lottoTickets = ArrayList<Lotto>()

    fun getLottoTicket(): ArrayList<Lotto> {

        for (i in 0..ticketNumber - 1) {

            val lotto = Lotto(TiketsController.getRandomNumber())
            lottoTickets.add(lotto)

        }
        return lottoTickets
    }
}
