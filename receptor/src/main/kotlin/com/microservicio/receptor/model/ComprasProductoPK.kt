package com.microservicio.receptor.model

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable


@Embeddable
class ComprasProductoPK : Serializable {
    @Column(name = "id_Compra")
    var idCompra: Int? = null

    @Column(name = "id_producto")
    var idProducto: Int? = null
}