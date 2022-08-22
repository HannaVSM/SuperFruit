package com.microservicio.receptor.negocio

import com.microservicio.receptor.model.Producto

interface IClienteBusiness {

    fun list(): List <Producto>
    fun load(id:String): Producto
    fun save (producto:Producto): Producto
    fun remove (id:String)
}