package com.mzhadan.phoneaccountingserver.repository

import com.mzhadan.phoneaccountingserver.models.Notification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface NotificationRepository: JpaRepository<Notification, Int> {

    @Query(
            value = "select * from notifications n",
            nativeQuery = true
    )
    fun getAllNotifications(): Optional<List<Notification>>

    @Query(
            value = "select * from notifications n where n.notificationId=?1",
            nativeQuery = true
    )
    fun getNotificationById(notificationId: Int): Optional<List<Notification>>
}