package com.mzhadan.phoneaccountingserver.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class SdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var sdcardId: Int = 0
    var inPhone: Boolean = false
    var phoneId: Int = 0
    var serialNumber: String = ""
    var size: String = ""
}