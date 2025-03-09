package lotto

import lotto.model.Lotto
import lotto.util.NumberValidator
import lotto.util.NumberValidator.checkRangeBonus
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest () {
    @Test
    fun `보너스번호가 숫자가 아니면 예외를 발생시킨다` () {
        assertThrows<IllegalArgumentException> {
            NumberValidator.checkBonusIsNumber("a")
        }
    }

    @Test
    fun `보너스번호가 당첨번호와 중복되면 예외를 발생시킨다`() {
        val winner = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonus = 1
        assertThrows<IllegalArgumentException> {
            NumberValidator.checkSameNumberBonus(winner, bonus)
        }
    }

    @Test
    fun `보너스번호가 1~45 사이의 숫자가 아니면 예외를 발생시킨다` () {
        assertThrows<IllegalArgumentException> {
            checkRangeBonus("0")
        }
    }
}