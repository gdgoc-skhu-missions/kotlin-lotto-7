package lotto.model

class LottoTickets(var purchaseCount: Int, var tickets: ArrayList<Lotto>) {
    private var lottoTickets = ArrayList<Lotto>()
    fun getLottoTickets(): LottoTickets {
        for (i in 0..purchaseCount - 1) {
            val lotto = Lotto.getRandomLotto()
            lottoTickets.add(lotto)
        }
        return LottoTickets(purchaseCount, lottoTickets);
    }
}