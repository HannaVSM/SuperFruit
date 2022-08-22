package com.microservicio.receptor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReceptorApplication

fun main(args: Array<String>) {
	runApplication<ReceptorApplication>(*args)
}
