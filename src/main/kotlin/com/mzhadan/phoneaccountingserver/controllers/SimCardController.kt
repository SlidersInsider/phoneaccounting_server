package com.mzhadan.phoneaccountingserver.controllers

import com.mzhadan.phoneaccountingserver.models.SimCard
import com.mzhadan.phoneaccountingserver.services.SimCardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/simcards")
class SimCardController(
    @Autowired
    private var simCardService: SimCardService
) {
    @GetMapping
    fun getSimCardsInfo(): List<SimCard> = simCardService.getSimCardsInfo()
}