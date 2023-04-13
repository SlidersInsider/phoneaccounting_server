package com.mzhadan.phoneaccountingserver.controllers

import com.mzhadan.phoneaccountingserver.models.SdCard
import com.mzhadan.phoneaccountingserver.services.SdCardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/sdcards")
class SdCardController(
    @Autowired
    private var sdCardService: SdCardService
) {
    @GetMapping
    fun getSdCardsInfo(): List<SdCard> = sdCardService.getSdCardsInfo()
}