package com.mzhadan.phoneaccountingserver.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "phone_info")
data class PhoneInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var phoneId: Int,
    var model: String,
    var manufacturer: String,
    var osVersion: String,
    var firmware: String,
    var supportedArch: String,
    var user: String,
    var simSlotsCount: Int,
    var simcard1: String,
    var simcard2: String,
    var sdSlotsCount: Int,
    var sdcard: String
)