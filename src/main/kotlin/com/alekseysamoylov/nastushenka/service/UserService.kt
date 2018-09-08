package com.alekseysamoylov.nastushenka.service

import com.alekseysamoylov.nastushenka.entity.User
import com.alekseysamoylov.nastushenka.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserService {

  @Autowired
  private lateinit var userRepository: UserRepository

  @Transactional
  fun getUser(apiUser: User): User {
    val dbUser = userRepository.findOneByUsername(apiUser.username)
    return if (dbUser != null) {
      if (BCryptPasswordEncoder().matches(apiUser.password, dbUser.password)) {
        dbUser
      } else {
        throw IllegalAccessError()
      }
    } else {
      apiUser.password = BCryptPasswordEncoder().encode(apiUser.password)
      userRepository.save(apiUser)
    }
  }
}
