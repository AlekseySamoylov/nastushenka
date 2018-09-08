package com.alekseysamoylov.nastushenka.entity

import javax.persistence.*

@Entity
@Table(name = "users")
class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null

  @Column
  lateinit var username: String

  @Column
  lateinit var password: String // to encrypt
}
