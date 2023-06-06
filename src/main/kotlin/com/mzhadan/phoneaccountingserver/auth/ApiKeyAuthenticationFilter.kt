package com.mzhadan.phoneaccountingserver.auth

import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ApiKeyAuthenticationFilter : AbstractAuthenticationProcessingFilter(AntPathRequestMatcher("/api/**")) {

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        val apiKey = extractApiKey(request)

        return authenticationManager.authenticate(ApiKeyAuthenticationToken(apiKey))
    }

    private fun extractApiKey(request: HttpServletRequest): String {
        val apiKey = request.getHeader("X-API-Key")
        if (apiKey.isNullOrEmpty()) {
            throw BadCredentialsException("API Key not found")
        }
        return apiKey
    }

    override fun successfulAuthentication(
            request: HttpServletRequest,
            response: HttpServletResponse,
            chain: FilterChain?,
            authResult: Authentication
    ) {
        chain?.doFilter(request, response)
        super.successfulAuthentication(request, response, chain, authResult)
    }
}