package com.microservicio.receptor.model

import javax.persistence.*


@Entity
@Table(name = "clientes")
class Cliente {
    @Id
    var id: String? = null
    var nombre: String? = null
    var apellidos: String? = null
    var celular: Long? = null
    var direccion: String? = null

    @Column(name = "correo_electronico")
    var correoElectronico: String? = null

    @OneToMany(mappedBy = "cliente")
    private val compra: List<Compra>? = null
}