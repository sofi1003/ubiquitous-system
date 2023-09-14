package com.unal.unchazapp.services.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoDTO {

	private Long idCatalogo;
	private String nombre;
	private Integer idNegocio;
	private List<ProductoDTO> productosDTO;

}
