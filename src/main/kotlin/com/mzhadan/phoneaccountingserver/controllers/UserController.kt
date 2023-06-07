package com.mzhadan.phoneaccountingserver.controllers

import com.mzhadan.phoneaccountingserver.models.PhoneInfo
import com.mzhadan.phoneaccountingserver.models.SimCard
import com.mzhadan.phoneaccountingserver.models.User
import com.mzhadan.phoneaccountingserver.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.math.log

@Controller
@RequestMapping("users")
class UserController(
        @Autowired
        private var userService: UserService
) {

    @GetMapping("/registration")
    fun showRegistrationPage() = "registration"

    @GetMapping("/login")
    fun showLoginPage() = "login"

    @GetMapping("/choose")
    fun showChoosePage() = "chooseReg"

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

    @PostMapping("/registration")
    fun addNewUser(@RequestParam login: String, @RequestParam password: String, model: Model): String {
        if (userService.addNewUser(login, password)) {
            return "redirect:profile/${login}"
        } else {
            model.addAttribute("errorMessage", "Username already exists!")
            return "registration"
        }
    }

    @GetMapping("/profile/{login}")
    fun showProfilePage(@PathVariable login: String, model: Model): String {
        val user = userService.getUserByLogin(login)
        model.addAttribute("user", user.get()[0])
        return "profile"
    }

    private fun isNewUser(user: List<User>): Boolean {
        return if (user.size == 0) {
            true
        } else {
            false
        }
    }

    @DeleteMapping("/delete/user/{id}")
    fun deleteUser(@PathVariable id: Int) {
        userService.deleteUser(id)
    }

    @PostMapping("/login")
    fun getUserByLogin(@RequestParam login: String, @RequestParam password: String, model: Model): String {
        val user: Optional<List<User>> = userService.getUserByLogin(login)
        if (isNewUser(user.get())) {
            model.addAttribute("errorMessage", "No user with this username!")
            return "login"
        } else {
            val userEl = user.get()[0]
            if (userEl.login.equals(login) && userEl.password.equals(password)) {
                return "redirect:profile/${login}"
            } else {
                model.addAttribute("errorMessage", "Incorrect login or password!")
                return "login"
            }
        }
    }
}