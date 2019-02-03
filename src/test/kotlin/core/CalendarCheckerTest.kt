package core

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class CalendarCheckerTest{

    @Autowired
    lateinit var  calendarChecker: CalendarChecker

    @Test
    fun whenAdding1and3_thenAnswerIs4() {

        assertEquals("Egor -> 02.02; Dima -> 06.02",  calendarChecker.check())
    }
}