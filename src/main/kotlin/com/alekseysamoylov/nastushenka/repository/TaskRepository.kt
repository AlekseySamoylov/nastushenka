package com.alekseysamoylov.nastushenka.repository

import com.alekseysamoylov.nastushenka.entity.Task
import com.alekseysamoylov.nastushenka.entity.User
import org.springframework.data.repository.CrudRepository


interface TaskRepository : CrudRepository<Task, Long> {
  fun findAllByUser(user: User): List<Task>?

}
