package core

import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate

/**
 * Чекатель ДРшек
 */
class CalendarChecker{

    @Autowired
    lateinit  var calendarRepository: CalendarRepository;

    /**
     * Чекаем у кого в этом месяце др
     */
    fun check (): String{


        var days = calendarRepository.findByMonth(LocalDate.now().month.value)

        //todo: return json object
        return days.joinToString("; ") { day -> "${day.person} -> ${day.date}" }
    }
}