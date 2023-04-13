package com.mzhadan.phoneaccountingserver.repository

import com.mzhadan.phoneaccountingserver.models.PhoneInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhoneInfoRepository: JpaRepository<PhoneInfo, Int> {
}