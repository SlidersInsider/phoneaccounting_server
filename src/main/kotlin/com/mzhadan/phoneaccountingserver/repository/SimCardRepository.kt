package com.mzhadan.phoneaccountingserver.repository

import com.mzhadan.phoneaccountingserver.models.SimCard
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SimCardRepository: JpaRepository<SimCard, Int> {
}