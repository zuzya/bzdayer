package runner

import domain.objects.Calendar

/**
 * Чекатель ДРшек
 */
class CalendarChecker{

    /**
     * Чекаем у кого в этом месяце др
     */
    fun check (): String{

        //todo: вычитать из БД/файла
        var days = listOf(Calendar("Egor", "02.02"), Calendar( "Dima", "06.02"))


        return days.joinToString("; ") { day -> "${day.person} -> ${day.date}" }
    }
}