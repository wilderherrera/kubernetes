package com.ms.ms_user

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
class MsUserApplication
fun main(args: Array<String>) {
    runApplication<MsUserApplication>(*args)
}
