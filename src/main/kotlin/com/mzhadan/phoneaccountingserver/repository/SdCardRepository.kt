package com.mzhadan.phoneaccountingserver.repository

import com.mzhadan.phoneaccountingserver.models.SdCard
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SdCardRepository: JpaRepository<SdCard, Int> {
}