package lotto.util

enum class Error(val message: String) {
    nothingInput("[ERROR] 아무것도 입력하지 않았습니다."),
    notInputNumberLotto("[ERROR] 당첨번호는 숫자와 쉼표(,)만 입력 가능합니다."),
    overInputLotto("[ERROR] 당첨번호가 6개를 초과하였습니다."),
    sameNumberInput("[ERROR] 당첨번호가 중복되었습니다."),
    overRangeLotto("[ERROR] 당첨번호는 1~45사이의 숫자여야합니다."),
    notInputNumberBonus("[ERROR] 보너스번호는 숫자만 입력 가능합니다."),
    sameNumberInputBonus("[ERROR] 보너스번호가 당첨번호와 중복되었습니다."),
    overRangeBonus("[ERROR] 보너스 번호는 1~45사이의 숫자여야합니다."),
    notInputNumberPurchase("[ERROR] 구매금액은 숫자만 입력 가능합니다."),
    canNotDivide("[ERROR] 구매금액은 1000으로 나누어 떨어져야합니다."),
}