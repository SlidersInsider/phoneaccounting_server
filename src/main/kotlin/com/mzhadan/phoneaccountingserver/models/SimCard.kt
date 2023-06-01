package com.mzhadan.phoneaccountingserver.models

import javax.persistence.*

@Entity
@Table(name = "simcards")
data class SimCard(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "simcardId")
    var simcardId: Int,
    @Column(name = "operatorName")
    var operatorName: String,
    @Column(name = "number")
    var number: String,
    @Column(name = "isLocked")
    var isLocked: String,
    @Column(name = "inPhone")
    var inPhone: String
)