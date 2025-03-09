package lotto.view

import camp.nextstep.edu.missionutils.Console

object Input {
    fun getPurchase(): String = Console.readLine()
    fun getWinnerNumber(): List<String> = Console.readLine().split(',')
    fun getBonusNumber(): String = Console.readLine()
}
