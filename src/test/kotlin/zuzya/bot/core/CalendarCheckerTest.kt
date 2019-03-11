package zuzya.bot.core

import zuzya.bot.controler.AbstractTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class CalendarCheckerTest : AbstractTest() {

    @Autowired
    lateinit var calendarChecker: CalendarChecker

    @Autowired
    lateinit var calendarRepository: CalendarRepository

    @Test
    fun whenCheckCurrentMonth_thenAnswerIsCorrect() {

        var egorCal = Calendar("Egor", "02.02", 3)
        calendarRepository.save(egorCal)

        var dimaCal = Calendar("Dima", "06.02", 3)
        calendarRepository.save(dimaCal)

        assertEquals("Egor -> 02.02; Dima -> 06.02", calendarChecker.check())
    }
}