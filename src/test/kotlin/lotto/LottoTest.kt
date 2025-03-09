package lotto

import lotto.model.Lotto
import lotto.util.NumberValidator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }
    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @Test
    fun `당첨 번호가 숫자가 아니면 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            NumberValidator.checkLottoIsNumber(listOf("qwer"))
        }
    }

    @Test
    fun `당첨 번호가 1~45 사이의 숫자가 아니면 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            NumberValidator.checkRangeLotto(listOf("100"))
        }
    }
}