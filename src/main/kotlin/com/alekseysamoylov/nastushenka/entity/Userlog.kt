package com.alekseysamoylov.nastushenka.entity

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "userlog")
class Userlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    public lateinit var username: String
    public lateinit var taskName: String
    public lateinit var taskType: String
    public lateinit var taskTime: Date
}
