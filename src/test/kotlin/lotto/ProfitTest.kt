package lotto

import lotto.model.Profit
import lotto.model.Purchase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProfitTest() {
    @Test
    fun `result를 받아 총 수익을 계산한다`() {
        val purchase = Purchase(50000)
        val winningResult = mutableMapOf(3 to 0, 4 to 1, 5 to 0, 6 to 0, 123 to 0)
        val profit = Profit(purchase, winningResult)
        assertThat(profit.calculateWinningAmount()).isEqualTo(50000)
    }

    @Test
    fun `총수익금액을 구입금액으로 나누어 수익률을 구한다`() {
        val purchase = Purchase(50000)
        val winningResult = mutableMapOf<Int, Int>(3 to 0, 4 to 1, 5 to 0, 6 to 0, 123 to 0)
        val profit = Profit(purchase, winningResult)
        assertThat(profit.calculateProfit()).isEqualTo(100.0)
    }
}