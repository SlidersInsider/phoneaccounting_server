package com.mzhadan.phoneaccountingserver.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class SimCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var simcardId: Int = 0
    var inPhone: Boolean = false
    var phoneId: Int = -1
    var number: String = ""
    var accounts: String = ""
}