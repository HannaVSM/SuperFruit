package com.microservicio.receptor.model
import javax.persistence.*;

@Entity
@Table(name = "categorias")
class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    var idCategoria: Int? = null
    var descripcion: String? = null
    var estado: Boolean? = null

    @OneToMany(mappedBy = "categoria")
    private val productos: List<Producto>? = null
}