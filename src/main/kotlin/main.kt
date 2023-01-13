const val mediumDiscount = 100
const val highDiscountInPercent = 5.0
const val overDiscountInPercent = 1.0
const val mediumDiscountStart = 1_001
const val highDiscountStart = 10_001
var resultPrice = 0.0

fun isReg(regularCustomer: String): Boolean = regularCustomer == "y"

fun basicDiscount(cost: Double): Double {
    resultPrice = if (cost < mediumDiscountStart) {
        cost
    } else if (cost < highDiscountStart) {
        (cost - mediumDiscount)
    } else {
        cost * (1 - highDiscountInPercent / 100)
    }
    return resultPrice
}

fun main() {
    println("Введите сумму покупки в руб.:")
    val cost: Double =
        readLine()!!.toDouble()
    println("Является ли клиент постоянным покупателем (y/n)?")

    val regularCustomer: String =
        readLine()!!
    val isRegular = isReg(regularCustomer)
    resultPrice = basicDiscount(cost)
    if (isRegular) resultPrice *= (1 - overDiscountInPercent / 100)
    print("Итоговая стоимость покупки составляет ${resultPrice.toInt()} руб.")
}

