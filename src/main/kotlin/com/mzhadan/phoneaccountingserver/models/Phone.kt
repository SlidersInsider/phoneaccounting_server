package com.mzhadan.phoneaccountingserver.models

data class Phone(
    var model: String,
    var manufacturer: String,
    var osVersion: String,
    var user: String,
    var simcard1: String,
    var simcard2: String,
    var sdcard: String,
)