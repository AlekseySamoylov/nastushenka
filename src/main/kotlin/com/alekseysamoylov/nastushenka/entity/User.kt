package com.alekseysamoylov.nastushenka.entity

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null
  lateinit var username: String
  lateinit var password: String
}
