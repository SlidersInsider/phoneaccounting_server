package com.mzhadan.phoneaccountingserver.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class SdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var sdcard_id: Int = 0
    var in_phone: Boolean = false
    var phone_id: Int = 0
    var serial_number: String = ""
    var size: String = ""
}