package com.mzhadan.phoneaccountingserver.repository

import com.mzhadan.phoneaccountingserver.models.Notification
import com.mzhadan.phoneaccountingserver.models.SdCard
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SdCardRepository: JpaRepository<SdCard, Int> {

    @Query(
            value = "select * from sdcards s",
            nativeQuery = true
    )
    fun getAllSdCards(): Optional<List<SdCard>>

    @Query(
            value = "select * from sdcards s where s.sdcardId=?1",
            nativeQuery = true
    )
    fun getSdCardById(sdcardId: Int): Optional<List<SdCard>>
}