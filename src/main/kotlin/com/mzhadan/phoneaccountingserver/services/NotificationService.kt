package com.mzhadan.phoneaccountingserver.services

import com.mzhadan.phoneaccountingserver.models.Notification
import com.mzhadan.phoneaccountingserver.repository.NotificationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class NotificationService(
        @Autowired
        private var notificationRepository: NotificationRepository
) {
    fun getAllNotifications(): Optional<List<Notification>> = notificationRepository.getAllNotifications()

    fun getNotificationById(notificationId: Int): Optional<List<Notification>> = notificationRepository.getNotificationById(notificationId)

    fun addNewNotification(notification: Notification) = notificationRepository.save(notification)
}