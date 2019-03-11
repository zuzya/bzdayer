package zuzya.bot

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication

@SpringBootApplication
class Runner

fun main(args: Array<String>) {
//    runApplication<Runner>(*args)


        SpringApplicationBuilder().initializers( beans()).sources(Runner::class.java).run(*args)

}