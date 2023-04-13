package com.mzhadan.phoneaccountingserver.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class PhoneInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var phone_id: Int = 0
    var model: String = ""
    var manufacturer: String = ""
    var os_version: String = ""
    var firmware: String = ""
    var supported_arch: String = ""
    var user: String = ""
    var sim_slots_count: Int = 0
    var simcard1_id: Int = 0
    var simcard2_id: Int = 0
    var sd_slots_count: Int = 0
    var sdcard_id: Int = 0
}