package com.alekseysamoylov.nastushenka.auth

import com.alekseysamoylov.nastushenka.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*


@Service
class TaskUserDetailsService : UserDetailsService {
  @Autowired
  private lateinit var userRepository: UserRepository

  override fun loadUserByUsername(username: String): UserDetails {
    val user = userRepository.findOneByUsername(username)
    return if (user != null) {
      org.springframework.security.core.userdetails.User(username, user.password,
          true, true, true, true,
          Arrays.asList(SimpleGrantedAuthority("ROLE_USER")))
    } else {
      throw IllegalAccessError("Wrong user")
    }
  }
}
