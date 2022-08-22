package com.microservicio.receptor.model

import javax.persistence.*


@Entity
@Table(name = "productos")
class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    var idProducto: Int? = null
    var nombre: String? = null

    @Column(name = "id_categoria")
    var idCategoria: Int? = null

    @Column(name = "codigo_barras")
    var codigoBarras: String? = null

    @Column(name = "precio_venta")
    var precioVenta: Double? = null

    @Column(name = "cantidad_stock")
    var cantidadStock: Int? = null
    var estado: Boolean? = null

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private val categoria: Categoria? = null
}