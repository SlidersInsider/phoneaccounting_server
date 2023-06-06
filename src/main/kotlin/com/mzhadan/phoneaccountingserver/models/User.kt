package com.mzhadan.phoneaccountingserver.models

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "userId")
        var userId: Int,
        @Column(name = "login")
        var login: String,
        @Column(name = "password")
        var password: String,
        @Column(name = "apiKey")
        var apiKey: String
)
