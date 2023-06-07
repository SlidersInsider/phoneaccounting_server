package com.mzhadan.phoneaccountingserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebSecurity
@EnableWebMvc
class PhoneAccountingServerApplication

fun main(args: Array<String>) {
    runApplication<PhoneAccountingServerApplication>(*args)
}


