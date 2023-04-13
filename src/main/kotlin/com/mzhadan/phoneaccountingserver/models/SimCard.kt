package com.mzhadan.phoneaccountingserver.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class SimCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var simcard_id: Int = 0
    var in_phone: Boolean = false
    var phone_id: Int = -1
    var number: String = ""
    var accounts: String = ""
}