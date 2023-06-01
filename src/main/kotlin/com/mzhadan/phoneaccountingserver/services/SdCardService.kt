package com.mzhadan.phoneaccountingserver.services

import com.mzhadan.phoneaccountingserver.models.Notification
import com.mzhadan.phoneaccountingserver.models.PhoneInfo
import com.mzhadan.phoneaccountingserver.models.SdCard
import com.mzhadan.phoneaccountingserver.repository.SdCardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class SdCardService(
    @Autowired
    private var sdCardRepository: SdCardRepository
) {
    fun getAllSdCards(): Optional<List<SdCard>> = sdCardRepository.getAllSdCards()

    fun getSdCardById(sdcardId: Int): Optional<List<SdCard>> = sdCardRepository.getSdCardById(sdcardId)

    fun addNewSdCard(sdCard: SdCard) = sdCardRepository.save(sdCard)

    fun deleteSdCard(sdCardId: Int) = sdCardRepository.deleteById(sdCardId)

    fun getSdCardBySerialNumber(serialNumber: String): Optional<List<SdCard>> =
            sdCardRepository.getSdCardBySerialNumber(serialNumber)
}