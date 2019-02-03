package core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import java.time.LocalDate

@DataJpaTest
class RepositoriesTests(@Autowired val entityManager: TestEntityManager,
                        @Autowired val calendarRepository: CalendarRepository
) {

    @Test
    fun `When findById then return Calendar`() {
        val calendar = Calendar("Egor", "02.02")
        entityManager.persist(calendar)
        entityManager.flush()

        val found = calendarRepository.findById(calendar.id!!)

        assertThat(found.get()).isEqualTo(calendar)
    }

    @Test
    fun `When findAllByOrderByCreatedAtDesc then return Calendars`() {
        val calendar = Calendar("Egor", "02.02")
        entityManager.persist(calendar)
        entityManager.flush()

        val founds = calendarRepository.findAllByOrderByCreatedAtDesc()

        assertThat(founds).isNotEmpty
    }

    @Test
    fun `When findByMonth then return Calendars`() {

        val calendar01 = Calendar("Egor", "02.01", 99)
        entityManager.persist(calendar01)

        var currentMonth = LocalDate.now().month.value
        val calendar02 = Calendar("Egor", "02.02", currentMonth)
        entityManager.persist(calendar02)
        entityManager.flush()

        val founds = calendarRepository.findByMonth(currentMonth)

        assertThat(founds.count()).isEqualTo(1)
    }


}