package lotto.util

import lotto.model.Lotto

object NumberValidator {
    fun winningNumberValidator(winningNumber: List<String>){
        winningNumber.forEach{ it -> checkBlank(it)}
        checkLottoIsNumber(winningNumber)
        checkOverInputLotto(winningNumber)
        checkSameNumberLotto(winningNumber)
        checkRangeLotto(winningNumber)
    }

    fun bonusNumberValidator(bonusNumber: String){
        checkBlank(bonusNumber)
        checkBonusIsNumber(bonusNumber)
        checkRangeBonus(bonusNumber)
    }

    fun purchaseValidator(purchase: String){
        checkBlank(purchase)
        checkPurchaseIsNumber(purchase)
        checkPurchaseCanDivid(purchase)
    }

    fun checkBlank(input: String) {
        require(!input.isBlank()) {
            Error.nothingInput.message
        }
    }

    fun checkLottoIsNumber(input: List<String>) {
        require(input.any{ it.matches("[0-9]*".toRegex())}){
            Error.notInputNumberLotto.message
        }
    }

    fun checkOverInputLotto(input: List<String>) {
        require(input.size == 6){
            Error.overInputLotto.message
        }
    }

    fun checkSameNumberLotto(input: List<String>) {
        require(input.toSet().size == 6){
            Error.sameNumberInput.message
        }
    }

    fun checkRangeLotto(input: List<String>) {
        require(input.any{ it.toInt() > 0 && it.toInt() < 46 }){
            Error.overRangeLotto.message
        }
    }

    fun checkBonusIsNumber(bonus: String) {
        require(bonus.matches("[0-9]*".toRegex())){
            Error.notInputNumberBonus.message
        }
    }

    fun checkRangeBonus(bonus: String) {
        require(bonus.toInt() > 0 && bonus.toInt() < 46){
            Error.overRangeBonus.message
        }
    }

    fun checkSameNumberBonus(winner: Lotto, bonus: Int) {
        require(!winner.checkBonusNumber(bonus)){
            Error.sameNumberInputBonus.message
        }
    }

    fun checkPurchaseIsNumber(purchase: String){
        require(purchase.matches("[0-9]*".toRegex())){
            Error.notInputNumberPurchase.message
        }
    }

    fun checkPurchaseCanDivid(purchase: String){
        require(purchase.toInt() % 1000 == 0){
            Error.canNotDivide.message
        }
    }
}