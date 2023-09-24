const val TYPE_MASTERCARD = "MasterCard"
const val TYPE_MAESTRO = "Maestro"
const val TYPE_VISA = "Visa"
const val TYPE_MIR = "Mir"
const val TYPE_VKPAY = "VKPay"
const val ERROR_WRONG_TYPE = -1.0
const val ERROR_LIMIT_EXCEEDED = -2.0

fun main() {
    println(comission(80_000, TYPE_MASTERCARD));
}

fun comission(transfer: Int, typeCard: String = TYPE_VKPAY, previous: Int = 0): Double {
    return when (typeCard) {
        TYPE_MASTERCARD, TYPE_MAESTRO -> {
            if (transfer > 150_000 || transfer + previous > 600_000) {
                ERROR_LIMIT_EXCEEDED
            } else {
                if (transfer <= 75_000) 0.0 else (transfer * 0.006) + 20
            }
        }

        TYPE_VISA, TYPE_MIR -> {
            if (transfer > 150_000 || transfer + previous > 600_000) {
                ERROR_LIMIT_EXCEEDED
            } else {
                if ((transfer * 0.0075) < 35.0) 35.0 else (transfer * 0.0075)
            }
        }
        TYPE_VKPAY -> {
            if (transfer > 15_000 || transfer + previous > 40_000) {
                ERROR_LIMIT_EXCEEDED
            } else 0.0
        }
        else -> ERROR_WRONG_TYPE
    }
}