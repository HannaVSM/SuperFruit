package com.microservicio.emisor.controlador

import com.fasterxml.jackson.databind.ObjectMapper
import com.microservicio.emisor.modelo.Producto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/products")

class ProductoControlador {

    @Autowired
    private val jmsTemplate: JmsTemplate? = null

    @PostMapping ("/save")
    fun insert(@RequestBody producto: Producto): String {
        val mapper = ObjectMapper()
        var conversion: String = mapper.writeValueAsString(producto)
        return sendMessage(conversion)
    }

    @RequestMapping("/send/active")
    fun sendMessage(@PathVariable message: String): String{

        if (message != null) {
            jmsTemplate!!.convertAndSend("spring-MQ", message)
        }
        return message
    }
}