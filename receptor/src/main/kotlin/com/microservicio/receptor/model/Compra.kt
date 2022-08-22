package com.microservicio.receptor.model

import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "compras")
class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    var idCompra: Int? = null

    @Column(name = "id_cliente")
    var idCliente: Int? = null
    var fecha: LocalDateTime? = null

    @Column(name = "medio_pago")
    var medioPago: String? = null
    var comentario: String? = null
    var estado: String? = null

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private val cliente: Cliente? = null
}
