package com.mzhadan.phoneaccountingserver.controllers

import com.mzhadan.phoneaccountingserver.models.SdCard
import com.mzhadan.phoneaccountingserver.models.SimCard
import com.mzhadan.phoneaccountingserver.services.SdCardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/sdcards")
class SdCardController(
    @Autowired
    private var sdCardService: SdCardService
) {
    @GetMapping("/all")
    fun getAllSdCards(): ResponseEntity<List<SdCard>> {
        val sdcards: Optional<List<SdCard>> = sdCardService.getAllSdCards()
        return checkResponseData(sdcards)
    }

    @GetMapping("/id/{sdcardId}")
    fun getSdCardById(@PathVariable sdcardId: Int): ResponseEntity<List<SdCard>> {
        val sdcards: Optional<List<SdCard>> = sdCardService.getSdCardById(sdcardId)
        return checkResponseData(sdcards)
    }

    private fun checkResponseData(responseEntity: Optional<List<SdCard>>): ResponseEntity<List<SdCard>> {
        return if (responseEntity.isPresent) {
            ResponseEntity<List<SdCard>>(responseEntity.get(), HttpStatus.OK)
        } else {
            ResponseEntity<List<SdCard>>(HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/add/sdcard")
    fun addNewSdCard(@RequestBody sdcard: SdCard) {
        sdCardService.addNewSdCard(sdcard)
    }

    @DeleteMapping("/delete/sdcard/{id}")
    fun deletePhoneInfo(@PathVariable id: Int) {
        sdCardService.deleteSdCard(id)
    }
}