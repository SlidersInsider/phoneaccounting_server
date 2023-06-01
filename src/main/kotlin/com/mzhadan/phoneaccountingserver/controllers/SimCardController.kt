package com.mzhadan.phoneaccountingserver.controllers

import com.mzhadan.phoneaccountingserver.models.Notification
import com.mzhadan.phoneaccountingserver.models.SdCard
import com.mzhadan.phoneaccountingserver.models.SimCard
import com.mzhadan.phoneaccountingserver.services.SimCardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/simcards")
class SimCardController(
    @Autowired
    private var simCardService: SimCardService
) {
    @GetMapping("/all")
    fun getAllSimCards(): ResponseEntity<List<SimCard>> {
        val simcards: Optional<List<SimCard>> = simCardService.getAllSimCards()
        return checkResponseData(simcards)
    }

    @GetMapping("/id/{simcardId}")
    fun getSimCardById(@PathVariable simcardId: Int): ResponseEntity<List<SimCard>> {
        val simcards: Optional<List<SimCard>> = simCardService.getSimCardById(simcardId)
        return checkResponseData(simcards)
    }

    private fun checkResponseData(responseEntity: Optional<List<SimCard>>): ResponseEntity<List<SimCard>> {
        return if (responseEntity.isPresent) {
            ResponseEntity<List<SimCard>>(responseEntity.get(), HttpStatus.OK)
        } else {
            ResponseEntity<List<SimCard>>(HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/add/simcard")
    fun addNewSimCard(@RequestBody simcard: SimCard) {
        simCardService.addNewSimCard(simcard)
    }

    @PutMapping("/update/simcard/{id}")
    fun updateSimCardIsLocked(@PathVariable id: Int, @RequestBody isLocked: String) {
        simCardService.updateSimCardIsLocked(isLocked, id)
    }

    @DeleteMapping("/delete/simcard/{id}")
    fun deleteSimCard(@PathVariable id: Int) {
        simCardService.deleteSimCard(id)
    }

    @GetMapping("number/{number}")
    fun getByNumber(@PathVariable number: String): ResponseEntity<List<SimCard>> {
        val simcard: Optional<List<SimCard>> = simCardService.getSimCardByNumber(number)
        return checkResponseData(simcard)
    }
}