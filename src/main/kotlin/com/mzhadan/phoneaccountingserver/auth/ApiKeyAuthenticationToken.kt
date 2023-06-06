package com.mzhadan.phoneaccountingserver.auth

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority

class ApiKeyAuthenticationToken(
        val apiKey: String,
        authorities: Collection<GrantedAuthority>
) : AbstractAuthenticationToken(authorities) {

    constructor(apiKey: String) : this(apiKey, emptyList())

    override fun getCredentials(): Any {
        return apiKey
    }

    override fun getPrincipal(): Any {
        return apiKey
    }
}