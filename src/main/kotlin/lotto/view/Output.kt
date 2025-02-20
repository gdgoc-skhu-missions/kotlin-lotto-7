package lotto.view

import lotto.model.Lotto

object Output {
    fun printPurchase() = println("구입금액을 입력해 주세요.")

    fun printTicketNumber(purchas: Int) = println("${purchas}개를 구매했습니다.")

    fun printTickets(tickets: ArrayList<Lotto>) = tickets.forEach { lotto -> println(lotto.getNumbers) }
}
