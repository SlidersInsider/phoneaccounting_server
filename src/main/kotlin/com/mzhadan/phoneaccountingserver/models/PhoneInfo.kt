package com.mzhadan.phoneaccountingserver.models

import javax.persistence.*

@Entity
@Table(name = "phone_info")
data class PhoneInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phoneId")
    var phoneId: Int,
    @Column(name = "model")
    var model: String,
    @Column(name = "manufacturer")
    var manufacturer: String,
    @Column(name = "osVersion")
    var osVersion: String,
    @Column(name = "convertedOsVersion")
    var convertedOsVersion: String,
    @Column(name = "firmware")
    var firmware: String,
    @Column(name = "supportedArch")
    var supportedArch: String,
    @Column(name = "user")
    var user: String,
    @Column(name = "simSlotsCount")
    var simSlotsCount: Int,
    @Column(name = "simcard1")
    var simcard1: String,
    @Column(name = "simcard2")
    var simcard2: String,
    @Column(name = "sdSlotsCount")
    var sdSlotsCount: Int,
    @Column(name = "sdcardSerialNumber")
    var sdcardSerialNumber: String
)