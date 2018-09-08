package com.alekseysamoylov.nastushenka.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table
class Report {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null

  @ManyToMany(cascade = [CascadeType.ALL])
  @JoinTable(
      name = "user",
      joinColumns = [JoinColumn(name = "id")],
      inverseJoinColumns = [JoinColumn(name = "user_id")]
  )
  lateinit var user: User

  @ManyToMany(cascade = [CascadeType.ALL])
  @JoinTable(
      name = "task",
      joinColumns = [JoinColumn(name = "id")],
      inverseJoinColumns = [JoinColumn(name = "task_id")]
  )
  lateinit var task: Task

  lateinit var time: LocalDateTime
}
