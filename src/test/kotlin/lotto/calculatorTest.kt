package lotto

import lotto.model.Lotto
import lotto.model.LottoTickets
import lotto.util.WinningResultCalculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class calculatorTest {
    private val winnerNumber = Lotto(listOf(1,2,3,4,5,6))
    private val bonusNumber = 7

    @Test
    fun `3개가 일치하면 key가 3인 value를 1증가시킨다`() {
        val lotto = Lotto(listOf(1,2,3,8,9,10))
        val lottoTickets = LottoTickets(0, arrayListOf(lotto))
        val winningResultCalculator = WinningResultCalculator(winnerNumber, bonusNumber, lottoTickets)
        val result = winningResultCalculator.calculcateResult()
        assertThat(result[3]).isEqualTo(1)
    }

    @Test
    fun `4개가 일치하면 key가 4인 value를 1증가시킨다`() {
        val lotto = Lotto(listOf(1,2,3,4,9,10))
        val lottoTickets = LottoTickets(0, arrayListOf(lotto))
        val winningResultCalculator = WinningResultCalculator(winnerNumber, bonusNumber, lottoTickets)
        val result = winningResultCalculator.calculcateResult()
        assertThat(result[4]).isEqualTo(1)
    }

    @Test
    fun `5개가 일치하고 보너스가 일치하면 key가 123인 value를 1증가시킨다`() {
        val lotto = Lotto(listOf(1,2,3,4,5,7))
        val lottoTickets = LottoTickets(0, arrayListOf(lotto))
        val winningResultCalculator = WinningResultCalculator(winnerNumber, bonusNumber, lottoTickets)
        val result = winningResultCalculator.calculcateResult()
        assertThat(result[123]).isEqualTo(1)
    }

    @Test
    fun `5개가 일치하고 보너스가 일치하지 않으면 key가 5인 value를 1증가시킨다`() {
        val lotto = Lotto(listOf(1,2,3,4,5,8))
        val lottoTickets = LottoTickets(0, arrayListOf(lotto))
        val winningResultCalculator = WinningResultCalculator(winnerNumber, bonusNumber, lottoTickets)
        val result = winningResultCalculator.calculcateResult()
        assertThat(result[5]).isEqualTo(1)
    }

    @Test
    fun `6개가 일치하면 key가 6인 value를 1증가시킨다`() {
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val lottoTickets = LottoTickets(0, arrayListOf(lotto))
        val winningResultCalculator = WinningResultCalculator(winnerNumber, bonusNumber, lottoTickets)
        val result = winningResultCalculator.calculcateResult()
        assertThat(result[6]).isEqualTo(1)
    }
}