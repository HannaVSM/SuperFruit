package com.microservicio.receptor.negocio

import com.microservicio.receptor.DAO.ClienteRepository
import com.microservicio.receptor.exception.BusinessException
import com.microservicio.receptor.model.Producto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.Throws

@Service
class ClienteBusiness: IClienteBusiness {

    @Autowired
    val clienteRepository: ClienteRepository?=null

    override fun list(): List<Producto> {
        return clienteRepository!!.findAll()
    }

    override fun load(id: String): Producto {
        TODO("Not yet implemented")
    }
    @Throws(BusinessException::class)
    override fun save(producto: Producto): Producto {
        try{
            return clienteRepository!!.save(producto)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    override fun remove(id: String) {
        TODO("Not yet implemented")
    }
}