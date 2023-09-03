package com.unal.unchazapp.services.helper;

import java.util.Objects;

import com.unal.unchazapp.domain.Usuario;
import com.unal.unchazapp.services.dto.UsuarioDTO;

public class UsuarioHelper {
//Esta clase es para transformar de DTO a entity y entity a DTO
	
	public static UsuarioDTO toUsuarioDTO(Usuario entity) {
		if(Objects.isNull(entity)) {
			return null;
		}
			
		UsuarioDTO dto =  new UsuarioDTO();
		dto.setIdUsuario(entity.getIdUsuario());
		dto.setDocumento(entity.getDocumento());
		dto.setUserName(entity.getUserName());
		dto.setPassword(entity.getPassword());
		dto.setEmail(entity.getEmail());
		
		return dto;
	}
	
	public static Usuario toUsuarioEntity(UsuarioDTO dto) {
		if(Objects.isNull(dto)) {
			return null;
		}
		Usuario entity =  new Usuario();
		entity.setIdUsuario(dto.getIdUsuario());
		entity.setDocumento(dto.getDocumento());
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setEmail(dto.getEmail());
		
		return entity;
	}
}
