package com.alekseysamoylov.nastushenka.entity

import javax.persistence.*

@Entity
@Table(name = "task")
class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null

  lateinit var name: String

  lateinit var type: TaskType

  var status = TaskStatus.OPEN

  lateinit var user: User
}
