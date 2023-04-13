package com.mzhadan.phoneaccountingserver.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class PhoneInfo(
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
    var simcard1Id: Int,
    var simcard2Id: Int,
    var sdSlotsCount: Int,
    var sdcardId: Int
) {
}