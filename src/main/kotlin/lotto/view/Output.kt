package lotto.view

import lotto.model.Lotto

object Output {
    fun printPurchaseMessage() = println("구입금액을 입력해 주세요.")

    fun printTicketNumberMessage(purcharseCount: Int) = println("${purcharseCount}개를 구매했습니다.")

    fun printTickets(tickets: ArrayList<Lotto>) = print(tickets.joinToString("\n"))

    fun printWineerNumberMessage() = println("\n당첨 번호를 입력해 주세요.")

    fun printBonusNumberMessage() = println("보너스 번호를 입력해 주세요.")

    fun printWinningResultMessage() = println("당첨통계")
    fun printWinningResult(result: Map<Int, Int>) {
        val resultMessage = StringBuilder()
        resultMessage.append("---\n")
        resultMessage.append("3개 일치 (5,000원) - ${result[3]}개\n")
        resultMessage.append("4개 일치 (50,000원) - ${result[4]}개\n")
        resultMessage.append("5개 일치 (1,500,000원) - ${result[5]}개\n")
        resultMessage.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result[123]}개\n")
        resultMessage.append("6개 일치 (2,000,000,000원) - ${result[6]}개\n")
        println(resultMessage.toString())
    }

    fun printProfitMessage(profit: Double) {
        print("총 수익률은 ${String.format("%.1f", profit)}%입니다.")
    }
}