package com.mzhadan.phoneaccountingserver.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "simcards")
data class SimCard(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var simcardId: Int,
    var operatorName: String,
    var number: String,
    var isLocked: String,
    var inPhone: String
)