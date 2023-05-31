package com.mzhadan.phoneaccountingserver.repository

import com.mzhadan.phoneaccountingserver.models.SdCard
import com.mzhadan.phoneaccountingserver.models.SimCard
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SimCardRepository: JpaRepository<SimCard, Int> {
    @Query(
            value = "select * from simcards s",
            nativeQuery = true
    )
    fun getAllSimCards(): Optional<List<SimCard>>

    @Query(
            value = "select * from simcards s where s.simcardId=?1",
            nativeQuery = true
    )
    fun getSimCardById(simcardId: Int): Optional<List<SimCard>>

    @Modifying
    @Query(
            value = "update simcards s set s.isLocked=?1 where s.simcardId=?2",
            nativeQuery = true
    )
    fun updateSimCardIsLocked(isLocked: String, simcardId: Int)
}