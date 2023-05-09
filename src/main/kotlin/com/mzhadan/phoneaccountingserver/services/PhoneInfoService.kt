package com.mzhadan.phoneaccountingserver.services

import com.mzhadan.phoneaccountingserver.models.PhoneInfo
import com.mzhadan.phoneaccountingserver.repository.PhoneInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class PhoneInfoService(
    @Autowired
    private var phoneInfoRepository: PhoneInfoRepository
) {
    fun getAllPhonesInfo(): Optional<List<PhoneInfo>> = phoneInfoRepository.getAllPhonesInfo()

    fun getPhoneInfoById(phoneId: Int): Optional<List<PhoneInfo>> = phoneInfoRepository.getPhonesInfoById(phoneId)

    fun getPhonesInfoByManufacturerName(manufacturer: String): Optional<List<PhoneInfo>> =
        phoneInfoRepository.getPhonesInfoByManufacturerName(manufacturer)

    fun addNewPhoneInfo(phoneInfo: PhoneInfo) = phoneInfoRepository.save(phoneInfo)

    fun deletePhoneInfo(phoneId: Int) = phoneInfoRepository.deleteById(phoneId)

    @Transactional
    fun updatePhoneUser(user: String, phoneId: Int) = phoneInfoRepository.updatePhoneUser(user, phoneId)
}