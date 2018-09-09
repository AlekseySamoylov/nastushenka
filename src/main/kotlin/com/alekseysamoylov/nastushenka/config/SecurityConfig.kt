package com.alekseysamoylov.nastushenka.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {

  override fun configure(http: HttpSecurity) {
    // @formatter:off
    http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/*").permitAll()
//        .antMatchers("/login*", "/signin/**", "/signup./&&").permitAll()
//        .anyRequest().authenticated()
//        .and()
//        .formLogin().loginPage("/login").permitAll()
        .and()
        .logout()
    // @formatter:on
  }

}
