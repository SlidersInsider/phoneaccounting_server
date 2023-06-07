package com.mzhadan.phoneaccountingserver.repository

import com.mzhadan.phoneaccountingserver.models.SdCard
import com.mzhadan.phoneaccountingserver.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*
import javax.security.auth.login.LoginContext

@Repository
interface UserRepository: JpaRepository<User, Int> {

    @Query(
            value = "select * from users u",
            nativeQuery = true
    )
    fun getAllUsers(): Optional<List<User>>

    @Query(
            value = "select * from users u where u.apiKey=?1",
            nativeQuery = true
    )
    fun getUserByApiKey(apiKey: String): Optional<List<User>>

    @Query(
            value = "select * from users u where u.login=?1",
            nativeQuery = true
    )
    fun getUserByLogin(login: String): Optional<List<User>>
}