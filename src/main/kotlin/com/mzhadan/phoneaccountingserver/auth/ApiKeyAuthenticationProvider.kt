package com.mzhadan.phoneaccountingserver.auth

import com.mzhadan.phoneaccountingserver.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component

@Component
class ApiKeyAuthenticationProvider(
        @Autowired
        private var userService: UserService
) : AuthenticationProvider {

    override fun supports(authentication: Class<*>): Boolean {
        return authentication == ApiKeyAuthenticationToken::class.java
    }

    override fun authenticate(authentication: Authentication): Authentication {
        val apiKey = (authentication as ApiKeyAuthenticationToken).apiKey

        if (isApiKeyValid(apiKey)) {
            val authenticatedToken = ApiKeyAuthenticationToken(apiKey, listOf(SimpleGrantedAuthority("ROLE_ADMIN")))
            authenticatedToken.isAuthenticated = true
            return authenticatedToken
        } else {
            throw BadCredentialsException("Invalid API Key")
        }
    }

    private fun isApiKeyValid(apiKey: String): Boolean {
        return userService.getUserByApiKey(apiKey).get().isNotEmpty()
    }
}