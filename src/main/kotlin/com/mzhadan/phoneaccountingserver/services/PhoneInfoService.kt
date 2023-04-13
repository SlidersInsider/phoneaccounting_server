package com.mzhadan.phoneaccountingserver.services

import com.mzhadan.phoneaccountingserver.models.PhoneInfo
import com.mzhadan.phoneaccountingserver.repository.PhoneInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PhoneInfoService(
    @Autowired
    private var phoneInfoRepository: PhoneInfoRepository
) {
    fun getPhonesInfo(): List<PhoneInfo> = phoneInfoRepository.findAll()
}