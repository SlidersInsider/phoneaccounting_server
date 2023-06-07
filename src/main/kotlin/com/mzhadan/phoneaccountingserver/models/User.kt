package com.mzhadan.phoneaccountingserver.models

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "userId")
        var userId: Int,
        @Column(name = "login", nullable = false, unique = true)
        var login: String,
        @Column(name = "password", nullable = false)
        var password: String,
        @Column(name = "apiKey", nullable = false, unique = true)
        var apiKey: String
)
