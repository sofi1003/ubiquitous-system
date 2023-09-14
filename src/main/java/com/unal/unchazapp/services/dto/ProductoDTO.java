package com.unal.unchazapp.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
	
	private Long id;
	private String nombreProducto;
	private Double precioProducto;    
	private String descripcionProducto;
    private Long idCatalogo;
}
