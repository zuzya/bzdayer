package zuzya.bot

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.context.support.beans

fun beans() = beans {

    bean("messageSource") {
        ReloadableResourceBundleMessageSource().apply {
            setBasename("messages")
            setDefaultEncoding("UTF-8")
        }
    }

    bean("jsonMapper") {

        ObjectMapper().registerModule(KotlinModule())
    }
}
