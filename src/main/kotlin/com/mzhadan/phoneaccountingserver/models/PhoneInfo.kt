package com.mzhadan.phoneaccountingserver.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class PhoneInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var phoneId: Int = 0
    var model: String = ""
    var manufacturer: String = ""
    var osVersion: String = ""
    var firmware: String = ""
    var supportedArch: String = ""
    var user: String = ""
    var simSlotsCount: Int = 0
    var simcard1Id: Int = 0
    var simcard2Id: Int = 0
    var sdSlotsCount: Int = 0
    var sdcardId: Int = 0
}