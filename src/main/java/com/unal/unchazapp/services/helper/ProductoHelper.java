package com.unal.unchazapp.services.helper;

import java.util.Objects;

import com.unal.unchazapp.domain.Catalogo;
import com.unal.unchazapp.domain.Producto;
import com.unal.unchazapp.services.dto.ProductoDTO;

public class ProductoHelper {
	
	public static ProductoDTO toProductoDTO(Producto entity) {
		if(Objects.isNull(entity)) {
			return null;
		}
		
		ProductoDTO dto = new ProductoDTO();
		dto.setId(entity.getId());
		dto.setNombreProducto(entity.getNombreProducto());
		dto.setPrecioProducto(entity.getPrecioProducto());
		dto.setDescripcionProducto(entity.getDescripcionProducto());
		dto.setIdCatalogo(entity.getCatalogo() != null ? entity.getCatalogo().getIdCatalogo() : null);
		
		return dto;
	}
	
	public static Producto toProductoEntity(ProductoDTO dto) {
		if(Objects.isNull(dto)) {
			return null;
		}
		
		Producto entity = new Producto();
		entity.setId(dto.getId());
		entity.setNombreProducto(dto.getNombreProducto());
		entity.setPrecioProducto(dto.getPrecioProducto());
		entity.setDescripcionProducto(dto.getDescripcionProducto());
		
		Catalogo cat = new Catalogo();
		cat.setIdCatalogo(dto.getIdCatalogo());
		entity.setCatalogo(cat);
	    
		return entity;
	}

}
