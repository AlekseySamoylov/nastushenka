package com.alekseysamoylov.nastushenka.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table
class Report {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null

  @ManyToOne(cascade = [CascadeType.ALL])
  @JoinColumn(name = "user_id")
  lateinit var user: User

  @ManyToOne(cascade = [CascadeType.ALL])
  @JoinColumn(name = "task_id")
  lateinit var task: Task

  @Column
  lateinit var time: LocalDateTime
}
