package com.microservicio.receptor.model

import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name = "compras_productos")
class ComprasProducto {
    @EmbeddedId
    var id: ComprasProductoPK? = null
    var cantidad: Int? = null
    var total: Double? = null
    var estado: Boolean? = null
}