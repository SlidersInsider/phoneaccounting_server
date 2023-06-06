package com.mzhadan.phoneaccountingserver.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.authentication.HttpStatusEntryPoint
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var apiKeyAuthenticationProvider: ApiKeyAuthenticationProvider

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .addFilterBefore(apiKeyAuthenticationFilter(), UsernamePasswordAuthenticationFilter::class.java)
                .exceptionHandling().authenticationEntryPoint(apiKeyAuthenticationEntryPoint())
    }

    @Bean
    fun apiKeyAuthenticationFilter(): ApiKeyAuthenticationFilter {
        val filter = ApiKeyAuthenticationFilter()
        filter.setAuthenticationManager(authenticationManagerBean())
        return filter
    }

    @Bean
    fun apiKeyAuthenticationEntryPoint(): AuthenticationEntryPoint {
        return HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(apiKeyAuthenticationProvider)
    }
}