package lotto

import lotto.model.Purchase
import lotto.util.NumberValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseTest {
    @Test
    fun `구입 금액이 숫자가 아니면 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            NumberValidator.checkPurchaseIsNumber("qwer")
        }
    }

    @Test
    fun `구입 금액이 1000으로 나누어 떨어지지 않으면 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            NumberValidator.checkPurchaseCanDivid("1234")
        }
    }

    @Test
    fun `구입 금액을 1000으로 나누어 구매 개수를 얻는다`() {
        val purchase = Purchase(10000)
        assertThat(purchase.getPurchaseCount()).isEqualTo(10)
    }

}