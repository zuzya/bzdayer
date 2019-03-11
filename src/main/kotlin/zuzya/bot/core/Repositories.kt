package zuzya.bot.core

import org.springframework.data.repository.CrudRepository

//todo: real db connection
interface CalendarRepository : CrudRepository<Calendar, Long> {

    fun findAllByOrderByCreatedAtDesc(): Iterable<Calendar>

    fun findByMonth(month: Int): Iterable<Calendar>
}