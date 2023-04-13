package com.mzhadan.phoneaccountingserver.services

import com.mzhadan.phoneaccountingserver.models.SimCard
import com.mzhadan.phoneaccountingserver.repository.SimCardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SimCardService(
    @Autowired
    private var simCardRepository: SimCardRepository
) {
    fun getSimCardsInfo(): List<SimCard> = simCardRepository.findAll()
}