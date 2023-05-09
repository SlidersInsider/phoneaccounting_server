package com.mzhadan.phoneaccountingserver.controllers

import com.mzhadan.phoneaccountingserver.models.Phone
import com.mzhadan.phoneaccountingserver.models.PhoneInfo
import com.mzhadan.phoneaccountingserver.services.PhoneInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.collections.ArrayList

@RestController
@RequestMapping("api/v1/phones")
class PhoneInfoController(
    @Autowired
    private var phoneInfoService: PhoneInfoService
) {

    @GetMapping("/all")
    fun getAllPhonesInfo(): ResponseEntity<List<PhoneInfo>> {
        val phoneInfo: Optional<List<PhoneInfo>> = phoneInfoService.getAllPhonesInfo()
        return checkResponseData(phoneInfo)
    }

    @GetMapping("/id/{phoneId}")
    fun getById(@PathVariable phoneId: Int): ResponseEntity<List<PhoneInfo>> {
        val phoneInfo: Optional<List<PhoneInfo>> = phoneInfoService.getPhoneInfoById(phoneId)
        return checkResponseData(phoneInfo)
    }

    @GetMapping("manufacturer/{mnfctr}")
    fun getByManufacturer(@PathVariable mnfctr: String): ResponseEntity<List<PhoneInfo>> {
        val phoneInfo: Optional<List<PhoneInfo>> = phoneInfoService.getPhonesInfoByManufacturerName(mnfctr)
        return checkResponseData(phoneInfo)
    }

    @GetMapping("/main")
    fun getMainPhonesInfo(): ResponseEntity<List<Phone>> {
        val phoneInfo: Optional<List<PhoneInfo>> = phoneInfoService.getAllPhonesInfo()
        return if (phoneInfo.isPresent) {
            val mainInfo = ArrayList<Phone>()
            phoneInfo.get().forEach {
                mainInfo.add(
                    Phone(
                    it.phoneId, it.model, it.manufacturer, it.osVersion,
                    it.user, it.simcard1, it.simcard2, it.sdcard)
                )
            }
            ResponseEntity<List<Phone>>(mainInfo, HttpStatus.OK)
        } else {
            ResponseEntity<List<Phone>>(HttpStatus.BAD_REQUEST)
        }
    }

    private fun checkResponseData(responseEntity: Optional<List<PhoneInfo>>): ResponseEntity<List<PhoneInfo>> {
        return if (responseEntity.isPresent) {
            ResponseEntity<List<PhoneInfo>>(responseEntity.get(), HttpStatus.OK)
        } else {
            ResponseEntity<List<PhoneInfo>>(HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/add/phone")
    fun addNewPhoneInfo(@RequestBody phoneInfo: PhoneInfo) {
        phoneInfoService.addNewPhoneInfo(phoneInfo)
    }

    @PutMapping("/update/user/{id}")
    fun updatePhoneUser(@PathVariable id: Int, @RequestBody user: String) {
        phoneInfoService.updatePhoneUser(user, id)
    }

    @DeleteMapping("/delete/phone/{id}")
    fun deletePhoneInfo(@PathVariable id: Int) {
        phoneInfoService.deletePhoneInfo(id)
    }
}