package com.unal.unchazapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
public class Producto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "catalogo_id")
    private Catalogo catalogo;
	
    @Column(name = "nombre_producto", length = 20)
	private String nombreProducto;
    
    @Column(name = "precio_producto", length = 20)
	private Float precioProducto;
    
    @Lob
    private byte[] imagenProducto;
    
    @Column(name = "descripcion_producto", length = 300)
	private String descripcionProducto;

}
