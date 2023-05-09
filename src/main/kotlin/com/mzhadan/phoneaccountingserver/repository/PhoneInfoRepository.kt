package com.mzhadan.phoneaccountingserver.repository

import com.mzhadan.phoneaccountingserver.models.Phone
import com.mzhadan.phoneaccountingserver.models.PhoneInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PhoneInfoRepository: JpaRepository<PhoneInfo, Int> {

    @Query(
        value = "select * from phone_info p",
        nativeQuery = true
    )
    fun getAllPhonesInfo(): Optional<List<PhoneInfo>>

    @Query(
        value = "select * from phone_info p where p.manufacturer=?1",
        nativeQuery = true
    )
    fun getPhonesInfoByManufacturerName(manufacturer: String): Optional<List<PhoneInfo>>

    @Query(
        value = "select * from phone_info p where p.phone_id=?1",
        nativeQuery = true
    )
    fun getPhonesInfoById(phoneId: Int): Optional<List<PhoneInfo>>

    @Modifying
    @Query(
        value = "update phone_info p set p.user=?1 where p.phone_id=?2",
        nativeQuery = true
    )
    fun updatePhoneUser(user: String, phoneId: Int)
}