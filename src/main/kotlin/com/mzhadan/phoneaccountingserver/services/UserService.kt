package com.mzhadan.phoneaccountingserver.services

import com.mzhadan.phoneaccountingserver.models.User
import com.mzhadan.phoneaccountingserver.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
        @Autowired
        private var userRepository: UserRepository
) {
        fun getAllUsers(): Optional<List<User>> = userRepository.getAllUsers()

        fun addNewUser(user: User) = userRepository.save(user)

        fun deleteUser(userId: Int) = userRepository.deleteById(userId)

        fun getUserByApiKey(apiKey: String): Optional<User> =
                userRepository.getUserByApiKey(apiKey)
}