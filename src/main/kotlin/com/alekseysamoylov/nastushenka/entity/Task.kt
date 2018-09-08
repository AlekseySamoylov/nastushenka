package com.alekseysamoylov.nastushenka.entity

import javax.persistence.*

@Entity
@Table
class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null

  @Column
  lateinit var name: String

  @Column
  @Enumerated(EnumType.STRING)
  lateinit var type: TaskType

  @Column
  @Enumerated(EnumType.STRING)
  var status = TaskStatus.OPEN

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  lateinit var user: User
}
