package com.alekseysamoylov.nastushenka

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class NastushenkaApplication

fun main(args: Array<String>) {
    SpringApplication.run(NastushenkaApplication::class.java, *args)
}
