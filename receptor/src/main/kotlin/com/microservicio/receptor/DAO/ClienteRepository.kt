package com.microservicio.receptor.DAO

import com.microservicio.receptor.model.Producto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClienteRepository: JpaRepository <Producto, Int>{
    fun findByNombreIgnoreCase(nombre:String): Optional<List<Producto>>
    //fun findByKeyAndOtherKey(...): ...

}