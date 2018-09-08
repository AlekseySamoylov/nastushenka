package com.alekseysamoylov.nastushenka.service

import com.alekseysamoylov.nastushenka.entity.User
import com.alekseysamoylov.nastushenka.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
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
      dbUser
    } else {
      userRepository.save(apiUser)
    }
  }
}
