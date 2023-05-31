package com.mzhadan.phoneaccountingserver.services

import com.mzhadan.phoneaccountingserver.models.SdCard
import com.mzhadan.phoneaccountingserver.models.SimCard
import com.mzhadan.phoneaccountingserver.repository.SimCardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class SimCardService(
    @Autowired
    private var simCardRepository: SimCardRepository
) {
    fun getAllSimCards(): Optional<List<SimCard>> = simCardRepository.getAllSimCards()

    fun getSimCardById(simcardId: Int): Optional<List<SimCard>> = simCardRepository.getSimCardById(simcardId)

    fun addNewSimCard(simcard: SimCard) = simCardRepository.save(simcard)

    fun deleteSimCard(simcardId: Int) = simCardRepository.deleteById(simcardId)

    @Transactional
    fun updateSimCardIsLocked(isLocked: String, simcardId: Int) = simCardRepository.updateSimCardIsLocked(isLocked, simcardId)
}