package com.microservicio.receptor.web

import com.google.gson.Gson
import com.microservicio.receptor.exception.BusinessException
import com.microservicio.receptor.exception.NotFoundException
import com.microservicio.receptor.model.Producto
import com.microservicio.receptor.negocio.IClienteBusiness
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.jms.annotation.JmsListener
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/products")

class ProductController {

    @Autowired
    val clienteBusiness: IClienteBusiness? = null

    @GetMapping("/all")
    fun list(): ResponseEntity <List<Producto>>{
        return try{
            ResponseEntity(clienteBusiness!!.list(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @GetMapping ("/{id}")
    fun load(@PathVariable("id") id:String): ResponseEntity <Producto>{
        return ResponseEntity(clienteBusiness!!.load(id), HttpStatus.OK)
    }

    @PostMapping ("/save")
    fun insert(@RequestBody json: String):Producto{
        val producto: Producto = Gson().fromJson(json, Producto::class.java)
       return clienteBusiness!!.save(producto)
    }
    @PutMapping("")
    fun update(@RequestBody producto: Producto): ResponseEntity<Any> {
        return try {
            clienteBusiness!!.save(producto)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String): ResponseEntity<Any> {
        return try {
            clienteBusiness!!.remove(id)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }

    }

    @JmsListener(destination = "spring-MQ")
    fun recvMessage(message: String) {
        System.out.println("El mensaje recibido es:$message")
        insert(message)
    }
}