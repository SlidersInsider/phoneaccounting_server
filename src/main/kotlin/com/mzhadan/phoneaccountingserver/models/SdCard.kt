package com.mzhadan.phoneaccountingserver.models

import javax.persistence.*

@Entity
@Table(name = "sdcards")
data class SdCard(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sdcardId")
    var sdcardId: Int,
    @Column(name = "name")
    var name: String,
    @Column(name = "serialNumber")
    var serialNumber: String,
    @Column(name = "size")
    var size: String,
    @Column(name = "inPhone")
    var inPhone: String,
)