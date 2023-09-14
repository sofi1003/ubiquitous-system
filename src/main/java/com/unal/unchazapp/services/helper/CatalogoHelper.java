package com.unal.unchazapp.services.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.unal.unchazapp.domain.Catalogo;
import com.unal.unchazapp.domain.Negocio;
import com.unal.unchazapp.domain.Producto;
import com.unal.unchazapp.services.dto.CatalogoDTO;
import com.unal.unchazapp.services.dto.ProductoDTO;

public class CatalogoHelper {

	public static CatalogoDTO toCatalogoDTO(Catalogo entity) {
		if(Objects.isNull(entity)) {
			return null;
		}
		
		CatalogoDTO dto = new CatalogoDTO();
		dto.setIdCatalogo(entity.getIdCatalogo());
		dto.setNombre(entity.getNombre());
		dto.setIdNegocio(entity.getNegocio() != null ? entity.getNegocio().getIdNegocio() : null);
		
		List<Producto> productos = entity.getProductos();
		if(productos!=null && !productos.isEmpty()){
			List<ProductoDTO> productosDTO = new ArrayList<>();
			for(Producto p: productos){
				ProductoDTO pdto = new ProductoDTO();
				pdto.setId(p.getId());
				pdto.setNombreProducto(p.getNombreProducto());
				pdto.setPrecioProducto(p.getPrecioProducto());
				pdto.setDescripcionProducto(p.getDescripcionProducto());
				productosDTO.add(pdto);
			}
			dto.setProductosDTO(productosDTO);
		}
		
		return dto;
	}
	
	public static Catalogo toCatalogoEntity(CatalogoDTO dto) {
		if(Objects.isNull(dto)) {
			return null;
		}
		
		Catalogo entity = new Catalogo();
		entity.setIdCatalogo(dto.getIdCatalogo());
		entity.setNombre(dto.getNombre());
		
		Negocio neg = new Negocio();
		neg.setIdNegocio(dto.getIdNegocio());
		entity.setNegocio(neg);
		
		return entity;
	}
}
