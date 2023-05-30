package com.mzhadan.phoneaccountingserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PhoneAccountingServerApplication {
    companion object {
        fun main(args: Array<String>) {
            runApplication<PhoneAccountingServerApplication>(*args)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<PhoneAccountingServerApplication>(*args)
}


