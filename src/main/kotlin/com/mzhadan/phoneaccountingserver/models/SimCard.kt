package com.mzhadan.phoneaccountingserver.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "simcards")
class SimCard(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var simcardId: Int,
    var inPhone: Int,
    var phoneId: Int,
    var number: String,
    var accounts: String
) {
}