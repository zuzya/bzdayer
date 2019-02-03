package runner

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class CalendarCheckerTest{

    private val calendarChecker = CalendarChecker()

    @Test
    fun whenAdding1and3_thenAnswerIs4() {

        assertEquals("Egor -> 02.02; Dima -> 06.02",  calendarChecker.check())
    }
}