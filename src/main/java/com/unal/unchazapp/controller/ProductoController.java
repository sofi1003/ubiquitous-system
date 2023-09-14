package com.unal.unchazapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unal.unchazapp.controller.dto.ResponseDTO;
import com.unal.unchazapp.services.ProductoService;
import com.unal.unchazapp.services.dto.ProductoDTO;

@RestController
@RequestMapping("api/v1/producto/")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH,
		RequestMethod.OPTIONS })
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@PostMapping("producto")
	public ResponseEntity<ResponseDTO> crearProducto(@RequestBody ProductoDTO dto) {
		ResponseDTO data = this.productoService.crear(dto);
		return new ResponseEntity<>(data,
				(data == null || !data.isSuccess() ? HttpStatus.NOT_ACCEPTABLE : HttpStatus.OK));
	}
	
	@PutMapping("modificarProducto")
	public ResponseEntity<ResponseDTO> modificarProducto(@RequestBody ProductoDTO dto){
		ResponseDTO data = this.productoService.modificar(dto);
		return new ResponseEntity<>(data,
				(data == null || !data.isSuccess() ? HttpStatus.NOT_ACCEPTABLE : HttpStatus.OK));
	}

}
