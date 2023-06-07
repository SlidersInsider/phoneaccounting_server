package com.mzhadan.phoneaccountingserver.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/")
class BaseController {

    @GetMapping("/")
    fun getAllNotifications(): String {
        return "Success"
    }
}