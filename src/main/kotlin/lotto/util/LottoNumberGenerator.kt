package lotto.util

import camp.nextstep.edu.missionutils.Randoms

private const val MAX_RANGE = 45
private const val MIN_RANGE = 1
private const val LOTTO_NUMBER_COUNT = 6

object LottoNumberGenerator {
    fun generator(): List<Int>{
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_NUMBER_COUNT).sorted()
    }
}