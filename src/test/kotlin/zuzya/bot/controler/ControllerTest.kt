package zuzya.bot.controler

import org.apache.http.HttpStatus
import org.junit.jupiter.api.Test
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.springframework.web.context.WebApplicationContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity.status
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.RequestBuilder
import org.springframework.test.web.servlet.ResultHandler
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import zuzya.bot.core.Calendar
import zuzya.bot.core.CalendarRepository


@EnableWebMvc
internal class ControllerTest  : AbstractTest(){

    var mockMvc: MockMvc? = null

    @Autowired
    private val wac: WebApplicationContext? = null

    @Autowired
    lateinit var calendarRepository: CalendarRepository

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac!!).build()
    }


    @Test
    fun whenCheckCurrentMonth_thenAnswerIsCorrect() {

        var egorCal = Calendar("Egor", "02.02", 3)
        calendarRepository.save(egorCal)

        var dimaCal = Calendar("Dima", "06.02", 3)
        calendarRepository.save(dimaCal)

        mockMvc!!.perform(MockMvcRequestBuilders.get("http://127.0.0.1:8080/current")).andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
    }
}