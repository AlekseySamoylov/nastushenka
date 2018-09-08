package com.alekseysamoylov.nastushenka.controller

import com.alekseysamoylov.nastushenka.entity.Userlog
import com.alekseysamoylov.nastushenka.repository.UserlogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@CrossOrigin
@RestController
class UserlogController {

    @Autowired
    private lateinit var taskRepository: UserlogRepository

    @PostMapping("/userlog")
    fun save(@RequestBody task: Userlog) {
        task.taskTime = Date()
        taskRepository.save(task)
    }
}
