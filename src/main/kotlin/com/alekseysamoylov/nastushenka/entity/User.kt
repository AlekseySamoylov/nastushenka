package com.alekseysamoylov.nastushenka.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "users")
class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null

  @Column
  lateinit var username: String


  @JsonIgnore
  @Column
  lateinit var password: String
}
