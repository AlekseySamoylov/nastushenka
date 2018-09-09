package com.alekseysamoylov.nastushenka.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.firewall.HttpFirewall
import org.springframework.security.web.firewall.StrictHttpFirewall


@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {

  @Bean
  fun allowUrlEncodedSlashHttpFirewall(): HttpFirewall {
    val firewall = StrictHttpFirewall()
    firewall.setAllowUrlEncodedSlash(true)
    return firewall
  }

  override fun configure(web: WebSecurity) {
    super.configure(web);
    web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
  }

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
