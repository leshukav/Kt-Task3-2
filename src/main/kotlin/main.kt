const val TYPE_1 = "Maestro"
const val TYPE_2 = "MasterCard"
const val TYPE_3 = "VISA"
const val TYPE_4 = "Мир"
const val TYPE_5 = "VK Pay"
const val MAXTRANSLATE_TYPE1_4 = 150_000
const val NOCOMMISSION_TYPE1_2 = 75_000
const val FIXCOMMISSION_TYPE1_2 = 20
const val COMMISSIONPERCENTAGE_TYPE1_2 = 0.006
const val MAXMONTHOFTRANSLATE_TYPE1_4 = 600_000
const val FIXCOMMISSION_TYPE3_4 = 35
const val COMMISSIONPERCENTAGE_TYPE3_4 = 0.0075
const val COMMISSIONPERCENTAGE_TYPE5 = 0
const val MAXAMOUNT_TYPE5 = 15_000
const val MAXMONTH_TYPE5 = 400_000
var translateMonthType1 = 0
var translateMonthType2 = 0
var translateMonthType3 = 0
var translateMonthType4 = 0
var translateMonthType5 = 0

fun main() {

    printTranslate(TYPE_1, 40_000)
    printTranslate(TYPE_1, 100_000)
    printTranslate(TYPE_1, 500_000)
    printTranslate(TYPE_2, 200_000)
    printTranslate(TYPE_2, 300_000)
    printTranslate(TYPE_2, 75_000)
    printTranslate(TYPE_3, 10_000)
    printTranslate(TYPE_3, 140_000)
    printTranslate(TYPE_4, 20_000)
    printTranslate(TYPE_4, 340_000)
    printTranslate(TYPE_5, 2_000)
    printTranslate(TYPE_5, 34_000)

}

fun printTranslate(type: String = TYPE_5, translate: Int) {
    when (type) {
        TYPE_1 -> {
            if ((translateMonthType1 + translate) > MAXMONTHOFTRANSLATE_TYPE1_4) {
                println("Превышен лимит переводов $MAXMONTHOFTRANSLATE_TYPE1_4 в месяц по карте $type  перевод  не возможен")
            } else if (translate < MAXTRANSLATE_TYPE1_4) {
                println("#################################################")
                println("Сумма перевода по карте: $type  $translate ")
                println("Комиссия: ${calcCommission(type, translate)}")
                translateMonthType1 += translate
                println("Сумма предыдущих переводов в этом месяце: $translateMonthType1")
            } else println("Перевод $translate не возможен! превышен лимит $MAXTRANSLATE_TYPE1_4")
        }
        TYPE_2 -> {
            if ((translateMonthType2 + translate) > MAXMONTHOFTRANSLATE_TYPE1_4) {
                println("Превышен лимит переводов $MAXTRANSLATE_TYPE1_4 в месяц по карте $type  перевод  не возможен")
            } else if (translate < MAXTRANSLATE_TYPE1_4) {
                println("#################################################")
                println("Сумма перевода по карте: $type  $translate ")
                println("Комиссия: ${calcCommission(type, translate)}")
                translateMonthType2 += translate
                println("Сумма предыдущих переводов в этом месяце: $translateMonthType2")
            } else println("Перевод $translate не возможен! превышен лимит $MAXTRANSLATE_TYPE1_4")
        }
        TYPE_3 -> {
            if ((translateMonthType3 + translate) > MAXMONTHOFTRANSLATE_TYPE1_4) {
                println("Превышен лимит переводов $MAXTRANSLATE_TYPE1_4 в месяц по карте $type  перевод  не возможен")
            } else if (translate < MAXTRANSLATE_TYPE1_4) {
                println("#################################################")
                println("Сумма перевода по карте: $type  $translate ")
                println("Комиссия: ${calcCommission(type, translate)}")
                translateMonthType3 += translate
                println("Сумма предыдущих переводов в этом месяце: $translateMonthType3")
            } else println("Перевод $translate не возможен! превышен лимит $MAXTRANSLATE_TYPE1_4")
        }
        TYPE_4 -> {
            if ((translateMonthType4 + translate) > MAXMONTHOFTRANSLATE_TYPE1_4) {
                println("Превышен лимит переводов $MAXTRANSLATE_TYPE1_4 в месяц по карте $type  перевод  не возможен")
            } else if (translate < MAXTRANSLATE_TYPE1_4) {
                println("#################################################")
                println("Сумма перевода по карте: $type  $translate ")
                println("Комиссия: ${calcCommission(type, translate)}")
                translateMonthType4 += translate
                println("Сумма предыдущих переводов в этом месяце: $translateMonthType4")
            } else println("Перевод $translate не возможен! превышен лимит $MAXTRANSLATE_TYPE1_4")
        }
        TYPE_5 -> {
            if ((translateMonthType5 + translate) > MAXMONTH_TYPE5) {
                println("Превышен лимит переводов $MAXMONTH_TYPE5 в месяц по карте $type  перевод  не возможен")
            } else if (translate < MAXAMOUNT_TYPE5) {
                println("#################################################")
                println("Сумма перевода по карте: $type  $translate ")
                println("Комиссия: ${calcCommission(type, translate)}")
                translateMonthType5 += translate
                println("Сумма предыдущих переводов в этом месяце: $translateMonthType5")
            } else println("Перевод $translate не возможен! превышен лимит $MAXAMOUNT_TYPE5")
        }
    }


}

fun calcCommission(type: String, translate: Int): Int {
    when (type) {
        TYPE_1, TYPE_2 -> {
            if ((translate) in (1..NOCOMMISSION_TYPE1_2)) return 0
            else return (FIXCOMMISSION_TYPE1_2 + COMMISSIONPERCENTAGE_TYPE1_2 * translate).toInt()
        }
        TYPE_3, TYPE_4 -> {
            if (COMMISSIONPERCENTAGE_TYPE3_4 * translate > FIXCOMMISSION_TYPE3_4)
                return (COMMISSIONPERCENTAGE_TYPE3_4 * translate).toInt()
            else return FIXCOMMISSION_TYPE3_4
        }
        TYPE_5 -> {
            return 0
        }
    }
    return 0
}