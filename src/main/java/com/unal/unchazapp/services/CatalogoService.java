package com.unal.unchazapp.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unal.unchazapp.controller.dto.ResponseDTO;
import com.unal.unchazapp.repository.ICatalogoRepository;
import com.unal.unchazapp.services.dto.CatalogoDTO;
import com.unal.unchazapp.services.helper.CatalogoHelper;

@Service
public class CatalogoService {

	@Autowired
	private ICatalogoRepository iCatalogoRepository;
	
	public ResponseDTO crear(CatalogoDTO dto) {
		ResponseDTO response = new ResponseDTO();
		try {
			if (Objects.isNull(dto)) {
				response.setSuccess(false);
				response.setMessage("No ha ingresado todos los datos requeridos. Por favor verificar");
			}
			this.iCatalogoRepository.save(CatalogoHelper.toCatalogoEntity(dto));
			response.setSuccess(true);
			response.setMessage("El catálogo fue almacenado satisfactoriamente.");
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage("Se ha presentado un error en el almacenamiento del catalogo");
		}
		return response;
	}
	
	public ResponseDTO modificar(CatalogoDTO dto) {
		ResponseDTO response = new ResponseDTO();
		try {
			if (Objects.isNull(dto) || Objects.isNull(dto.getIdCatalogo())) {
				response.setSuccess(false);
				response.setMessage("No ha ingresado todos los datos requeridos. Por favor verificar");
			}
			this.iCatalogoRepository.save(CatalogoHelper.toCatalogoEntity(dto));
			response.setSuccess(true);
			response.setMessage("El catálogo fue actualizado satisfactoriamente.");
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage("Se ha presentado un error en el almacenamiento del catalogo");
		}
		return response;
	}
	
}
