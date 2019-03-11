package zuzya.bot.core

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.logging.Logger

/**
 * Чекатель ДРшек
 */
@Component
class CalendarChecker{

    val LOG = Logger.getLogger(this.javaClass.name)


    @Autowired
    lateinit  var calendarRepository: CalendarRepository;

    /**
     * Чекаем у кого в этом месяце др
     */
    fun check (): Iterable<Calendar>{


        var days = calendarRepository.findByMonth(LocalDate.now().month.value)

        LOG.info(days.joinToString("; ") { day -> "${day.person} -> ${day.date}" })

        return days
    }
}