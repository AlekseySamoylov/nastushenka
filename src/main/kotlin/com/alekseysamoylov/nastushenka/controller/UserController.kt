package com.alekseysamoylov.nastushenka.controller

import com.alekseysamoylov.nastushenka.entity.User
import com.alekseysamoylov.nastushenka.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
class UserController {

  @Autowired
  private lateinit var userService: UserService

  @PostMapping("login")
  fun login(username: String, password: String): User {
    val user = User()
    user.username = username
    user.password = password
    return userService.getUser(user)
  }
}
