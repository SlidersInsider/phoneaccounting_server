package com.mzhadan.phoneaccountingserver.controllers

import com.mzhadan.phoneaccountingserver.models.Notification
import com.mzhadan.phoneaccountingserver.models.PhoneInfo
import com.mzhadan.phoneaccountingserver.services.NotificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("api/v1/notifications")
class NotificationController(
        @Autowired
        private var notificationService: NotificationService
) {

    @GetMapping("/all")
    fun getAllNotifications(): ResponseEntity<List<Notification>> {
        val notifications: Optional<List<Notification>> = notificationService.getAllNotifications()
        return checkResponseData(notifications)
    }

    @GetMapping("/id/{notificationId}")
    fun getNotificationById(@PathVariable notificationId: Int): ResponseEntity<List<Notification>> {
        val notifications: Optional<List<Notification>> = notificationService.getNotificationById(notificationId)
        return checkResponseData(notifications)
    }

    private fun checkResponseData(responseEntity: Optional<List<Notification>>): ResponseEntity<List<Notification>> {
        return if (responseEntity.isPresent) {
            ResponseEntity<List<Notification>>(responseEntity.get(), HttpStatus.OK)
        } else {
            ResponseEntity<List<Notification>>(HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/add/notification")
    fun addNewPhoneInfo(@RequestBody notification: Notification) {
        notificationService.addNewNotification(notification)
    }
}