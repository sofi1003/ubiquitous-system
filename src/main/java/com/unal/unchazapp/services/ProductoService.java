package com.unal.unchazapp.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unal.unchazapp.controller.dto.ResponseDTO;
import com.unal.unchazapp.repository.IProductoRepository;
import com.unal.unchazapp.services.dto.ProductoDTO;
import com.unal.unchazapp.services.helper.ProductoHelper;

@Service
public class ProductoService {

	@Autowired
	private IProductoRepository iProductoRepository;
	
	public ResponseDTO crear(ProductoDTO dto) {
		ResponseDTO response = new ResponseDTO();
		try {
			if (Objects.isNull(dto)) {
				response.setSuccess(false);
				response.setMessage("No ha ingresado todos los datos requeridos. Por favor verificar");
			}
			this.iProductoRepository.save(ProductoHelper.toProductoEntity(dto));
			response.setSuccess(true);
			response.setMessage("El producto fue almacenado satisfactoriamente.");
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setMessage("Se ha presentado un error en el almacenamiento del producto.");
		}
		return response;
	}
	
	public ResponseDTO modificar(ProductoDTO dto) {
		ResponseDTO response = new ResponseDTO();
		try {
			if (Objects.isNull(dto) || Objects.isNull(dto.getId())) {
				response.setSuccess(false);
				response.setMessage("No ha ingresado todos los datos requeridos. Por favor verificar");
			}
			this.iProductoRepository.save(ProductoHelper.toProductoEntity(dto));
			response.setSuccess(true);
			response.setMessage("El producto fue actualizado satisfactoriamente.");
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage("Se ha presentado un error en el almacenamiento del producto");
		}
		return response;
	}
}
