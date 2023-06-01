package com.mzhadan.phoneaccountingserver.models

import javax.persistence.*

@Entity
@Table(name = "notifications")
data class Notification(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "notificationId")
        var notificationId: Int,
        @Column(name = "title")
        var title: String,
        @Column(name = "notificationText")
        var notificationText: String,
        @Column(name = "packageName")
        var packageName: String
)
