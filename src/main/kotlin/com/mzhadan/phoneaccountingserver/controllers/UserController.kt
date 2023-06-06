package com.mzhadan.phoneaccountingserver.controllers

import com.mzhadan.phoneaccountingserver.models.PhoneInfo
import com.mzhadan.phoneaccountingserver.models.User
import com.mzhadan.phoneaccountingserver.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/users")
class UserController(
        @Autowired
        private var userService: UserService
) {

    @GetMapping("/all")
    fun getAllUsers(): ResponseEntity<List<User>> {
        val users: Optional<List<User>> = userService.getAllUsers()
        return checkResponseData(users)
    }

    private fun checkResponseData(responseEntity: Optional<List<User>>): ResponseEntity<List<User>> {
        return if (responseEntity.isPresent) {
            ResponseEntity<List<User>>(responseEntity.get(), HttpStatus.OK)
        } else {
            ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/add/user")
    fun addNewUser(@RequestBody user: User) {
        userService.addNewUser(user)
    }

    @DeleteMapping("/delete/user/{id}")
    fun deleteUser(@PathVariable id: Int) {
        userService.deleteUser(id)
    }


}