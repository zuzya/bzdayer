package zuzya.bot.core

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Calendar(

    var person: String,

    var date: String,

    var month: Int? = null,

    @Id @GeneratedValue val id: Long? = null,

    val createdAt: LocalDateTime = LocalDateTime.now()
)