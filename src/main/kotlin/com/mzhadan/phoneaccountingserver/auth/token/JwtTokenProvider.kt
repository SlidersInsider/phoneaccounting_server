package com.mzhadan.phoneaccountingserver.auth.token

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import lombok.Value
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*
import kotlin.math.exp

@Component
class JwtTokenProvider {
    private var jwtSecret: String = ""
    private var jwtExpirationMs: Long = 0

    init {
        jwtSecret = "fdshkfjsdhfiewtuewtpsddfgdsfgyrrwe3423gyjv234fj24v3j24j5vy1gjfgfbdsfsdf2545fgsdfjsadasjkfdasvgdftysfwdweg"
        jwtExpirationMs = 3600000000
    }


    fun generateToken(): String {
        val now = Date()
        val expiryDate = Date(now.time + jwtExpirationMs)

        return Jwts.builder()
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact()
    }
}