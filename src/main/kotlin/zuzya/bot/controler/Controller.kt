package zuzya.bot.controler

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import zuzya.bot.core.CalendarChecker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @Autowired
    lateinit var calendarChecker: CalendarChecker

    @GetMapping("/current")
    fun checkCurrentMonth(): List<CalendarModel> {

        return calendarChecker.check().map { cal -> CalendarModel(cal.person, cal.date) }
    }


}