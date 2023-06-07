package com.mzhadan.phoneaccountingserver.services

import com.mzhadan.phoneaccountingserver.auth.token.JwtTokenProvider
import com.mzhadan.phoneaccountingserver.models.User
import com.mzhadan.phoneaccountingserver.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.math.log

@Service
class UserService(
        @Autowired
        private var userRepository: UserRepository,
        @Autowired
        private var jwtTokenProvider: JwtTokenProvider
) {
        fun getAllUsers(): Optional<List<User>> = userRepository.getAllUsers()

        fun addNewUser(login: String, password: String): Boolean {
                if (userRepository.getUserByLogin(login).get().size == 0) {
                        val apiKey = jwtTokenProvider.generateToken()
                        userRepository.save(User(0, login, password, apiKey))
                        return true
                } else {
                        return false
                }
        }

        fun deleteUser(userId: Int) = userRepository.deleteById(userId)

        fun getUserByApiKey(apiKey: String): Optional<List<User>> =
                userRepository.getUserByApiKey(apiKey)

        fun getUserByLogin(login: String): Optional<List<User>> =
                userRepository.getUserByLogin(login)

}