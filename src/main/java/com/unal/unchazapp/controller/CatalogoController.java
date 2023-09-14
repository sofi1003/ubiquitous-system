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
import com.unal.unchazapp.services.CatalogoService;
import com.unal.unchazapp.services.dto.CatalogoDTO;

@RestController
@RequestMapping("api/v1/catalogo/")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH,
		RequestMethod.OPTIONS })
public class CatalogoController {

	@Autowired
	private CatalogoService catalogoService;
	
	@PostMapping("catalogo")
	public ResponseEntity<ResponseDTO> crearCatalogo(@RequestBody CatalogoDTO dto) {
		ResponseDTO data = this.catalogoService.crear(dto);
		return new ResponseEntity<>(data,
				(data == null || !data.isSuccess() ? HttpStatus.NOT_ACCEPTABLE : HttpStatus.OK));
	}
	
	@PutMapping("modificarCatalogo")
	public ResponseEntity<ResponseDTO> modificarCatalogo(@RequestBody CatalogoDTO dto){
		ResponseDTO data = this.catalogoService.modificar(dto);
		return new ResponseEntity<>(data,
				(data == null || !data.isSuccess() ? HttpStatus.NOT_ACCEPTABLE : HttpStatus.OK));
	}
}
