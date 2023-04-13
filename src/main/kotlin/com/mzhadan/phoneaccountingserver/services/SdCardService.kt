package com.mzhadan.phoneaccountingserver.services

import com.mzhadan.phoneaccountingserver.models.SdCard
import com.mzhadan.phoneaccountingserver.repository.SdCardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SdCardService(
    @Autowired
    private var sdCardRepository: SdCardRepository
) {
    fun getSdCardsInfo(): List<SdCard> = sdCardRepository.findAll()
}