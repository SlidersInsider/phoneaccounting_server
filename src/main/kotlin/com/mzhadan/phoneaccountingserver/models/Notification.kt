package com.mzhadan.phoneaccountingserver.models

import javax.persistence.*

@Entity
@Table(name = "notifications")
data class Notification(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var notificationId: Int,
        var title: String,
        var notificationText: String,
        var packageName: String
)
