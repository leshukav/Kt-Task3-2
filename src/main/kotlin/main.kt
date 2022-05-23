const val MAESTRO = "Maestro"
const val MASTERCARD = "MasterCard"
const val VISA = "VISA"
const val WORLD = "Мир"
const val VK_PAY = "VK Pay"
const val MAXTRANSLATE_MAESTRO = 150_000
const val MAXTRANSLATE_MASTERCARD = 150_000
const val MAXTRANSLATE_VISA = 150_000
const val MAXTRANSLATE_WORD = 150_000
const val NOCOMMISSION_MAESTRO = 75_000
const val NOCOMMISSION_MASTERCARD = 75_000
const val FIXCOMMISSION_MAESTRO = 20
const val FIXCOMMISSION_MASTERCARD = 20
const val COMMISSIONPERCENTAGE_MAESTRO = 0.006
const val COMMISSIONPERCENTAGE_MASTERCARD = 0.006
const val MAXMONTHOFTRANSLATE_MAESTRO = 600_000
const val MAXMONTHOFTRANSLATE_MASTERCARD = 600_000
const val MAXMONTHOFTRANSLATE_VISA = 600_000
const val MAXMONTHOFTRANSLATE_WORD = 600_000
const val FIXCOMMISSION_VISA = 35
const val FIXCOMMISSION_WORD = 35
const val COMMISSIONPERCENTAGE_VISA = 0.0075
const val COMMISSIONPERCENTAGE_WORD = 0.0075
const val COMMISSIONPERCENTAGE_VK_PAY = 0

const val MAXAMOUNT_VK_PAY = 15_000
const val MAXMONTH_VK_PAY = 400_000
var translateMonthMAESTRO = 0
var translateMonthMASTERCARD = 0
var translateMonthVISA = 0
var translateMonthWORLD = 0
var translateMonthVK_PAY = 0

fun main() {

    printTranslate(MAESTRO, 40_000)
    printTranslate(MAESTRO, 100_000)
    printTranslate(MAESTRO, 500_000)
    printTranslate(MASTERCARD, 200_000)
    printTranslate(MASTERCARD, 300_000)
    printTranslate(MASTERCARD, 75_000)
    printTranslate(VISA, 10_000)
    printTranslate(VISA, 140_000)
    printTranslate(WORLD, 20_000)
    printTranslate(WORLD, 340_000)
    printTranslate(VK_PAY, 2_000)
    printTranslate(VK_PAY, 34_000)

}

fun printTranslate(type: String = VK_PAY, translate: Int) {
    when (type) {
        MAESTRO -> {
            if (calcCommission(type, translateMonthMAESTRO, translate) == -100) {
                println("Превышен лимит переводов $MAXMONTHOFTRANSLATE_MAESTRO в месяц по карте $type  перевод  не возможен")
            } else if (translate < MAXTRANSLATE_MAESTRO) {
                println("#################################################")
                println("Сумма перевода по карте: $type  $translate ")
                println("Комиссия: ${calcCommission(type, translateMonthMAESTRO, translate)}")
                translateMonthMAESTRO += translate
                println("Сумма предыдущих переводов в этом месяце: $translateMonthMAESTRO")
            } else println("Перевод $translate не возможен! превышен суточный лимит $MAXTRANSLATE_MAESTRO")
        }
        MASTERCARD -> {
            if (calcCommission(type, translateMonthMASTERCARD, translate) == -100) {
                println("Превышен лимит переводов $MAXTRANSLATE_MASTERCARD в месяц по карте $type  перевод  не возможен")
            } else if (translate < MAXTRANSLATE_MASTERCARD) {
                println("#################################################")
                println("Сумма перевода по карте: $type  $translate ")
                println("Комиссия: ${calcCommission(type, translateMonthMASTERCARD, translate)}")
                translateMonthMASTERCARD += translate
                println("Сумма предыдущих переводов в этом месяце: $translateMonthMASTERCARD")
            } else println("Перевод $translate не возможен! превышен суточный лимит $MAXTRANSLATE_MASTERCARD")
        }
        VISA -> {
            if (calcCommission(type, translateMonthVISA, translate) == -100) {
                println("Превышен лимит переводов $MAXTRANSLATE_VISA в месяц по карте $type  перевод  не возможен")
            } else if (translate < MAXTRANSLATE_VISA) {
                println("#################################################")
                println("Сумма перевода по карте: $type  $translate ")
                println("Комиссия: ${calcCommission(type, translateMonthVISA, translate)}")
                translateMonthVISA += translate
                println("Сумма предыдущих переводов в этом месяце: $translateMonthVISA")
            } else println("Перевод $translate не возможен! превышен суточный лимит $MAXTRANSLATE_VISA")
        }
        WORLD -> {
            if (calcCommission(type, translateMonthWORLD, translate) == -100) {
                println("Превышен лимит переводов $MAXTRANSLATE_WORD в месяц по карте $type  перевод  не возможен")
            } else if (translate < MAXTRANSLATE_WORD) {
                println("#################################################")
                println("Сумма перевода по карте: $type  $translate ")
                println("Комиссия: ${calcCommission(type, translateMonthWORLD, translate)}")
                translateMonthWORLD += translate
                println("Сумма предыдущих переводов в этом месяце: $translateMonthWORLD")
            } else println("Перевод $translate не возможен! превышен суточный лимит $MAXTRANSLATE_WORD")
        }
        VK_PAY -> {
            if (calcCommission(type, translateMonthVK_PAY, translate) == -100) {
                println("Превышен лимит переводов $MAXMONTH_VK_PAY в месяц по карте $type  перевод  не возможен")
            } else if (translate < MAXAMOUNT_VK_PAY) {
                println("#################################################")
                println("Сумма перевода по карте: $type  $translate ")
                println("Комиссия: ${calcCommission(type, translateMonthVK_PAY, translate)}")
                translateMonthVK_PAY += translate
                println("Сумма предыдущих переводов в этом месяце: $translateMonthVK_PAY")
            } else println("Перевод $translate не возможен! превышен суточный лимит $MAXAMOUNT_VK_PAY")
        }
    }


}

fun calcCommission(type: String = VK_PAY, translateMonth: Int = 0, translate: Int): Int {
    when (type) {
        MAESTRO -> {
            return if (translateMonth + translate > MAXMONTHOFTRANSLATE_MAESTRO) -100
            else if ((translate) in (1..NOCOMMISSION_MAESTRO)) 0
            else (FIXCOMMISSION_MAESTRO + COMMISSIONPERCENTAGE_MAESTRO * translate).toInt()
        }
        MASTERCARD -> {
            return if (translateMonth + translate > MAXMONTHOFTRANSLATE_MASTERCARD) -100
            else if ((translate) in (1..NOCOMMISSION_MASTERCARD)) 0
            else (FIXCOMMISSION_MASTERCARD + COMMISSIONPERCENTAGE_MASTERCARD * translate).toInt()
        }
        VISA -> {
            return if (translateMonth + translate > MAXMONTHOFTRANSLATE_VISA) -100
            else if (COMMISSIONPERCENTAGE_VISA * translate > FIXCOMMISSION_VISA)
                (COMMISSIONPERCENTAGE_VISA * translate).toInt()
            else FIXCOMMISSION_VISA
        }
        WORLD -> {
            return if (translateMonth + translate > MAXMONTHOFTRANSLATE_WORD) -100
            else if (COMMISSIONPERCENTAGE_WORD * translate > FIXCOMMISSION_WORD)
                (COMMISSIONPERCENTAGE_WORD * translate).toInt()
            else FIXCOMMISSION_WORD
        }
        VK_PAY -> {
            return if (translateMonth + translate > MAXMONTH_VK_PAY) -100
            else 0
        }
    }
    return 0
}