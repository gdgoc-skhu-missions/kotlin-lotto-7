package lotto.model

class Purchase(val amount: Int) {
    fun getPurchaseCount(): Int = amount / 1000
}