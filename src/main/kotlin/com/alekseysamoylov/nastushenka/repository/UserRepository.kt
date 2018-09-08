package com.alekseysamoylov.nastushenka.repository

import com.alekseysamoylov.nastushenka.entity.User
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<User, Long> {
  fun findOneByUsername(username: String): User?
}
