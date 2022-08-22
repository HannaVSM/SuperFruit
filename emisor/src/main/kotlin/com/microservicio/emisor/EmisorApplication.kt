package com.microservicio.emisor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EmisorApplication

fun main(args: Array<String>) {
	runApplication<EmisorApplication>(*args)
}
