package com.mzhadan.phoneaccountingserver.controllers

import com.mzhadan.phoneaccountingserver.models.PhoneInfo
import com.mzhadan.phoneaccountingserver.services.PhoneInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/phones")
class PhoneInfoController(
    @Autowired
    private var phoneInfoService: PhoneInfoService
) {
    @GetMapping
    fun getPhonesInfo(): List<PhoneInfo> = phoneInfoService.getPhonesInfo()
}