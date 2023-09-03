package com.unal.unchazapp.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unal.unchazapp.controller.dto.ResponseDTO;
import com.unal.unchazapp.domain.Usuario;
import com.unal.unchazapp.repository.IUsuarioRepository;
import com.unal.unchazapp.services.dto.UsuarioDTO;
import com.unal.unchazapp.services.helper.UsuarioHelper;

@Service
public class UsuarioService {
	
	@Autowired
	private IUsuarioRepository iuUsuarioRepository;

	public ResponseDTO crear(UsuarioDTO dto) {
		ResponseDTO response =  new ResponseDTO();
		try	{
			if(Objects.isNull(dto)) {
				response.setSuccess(false);
				response.setMessage("No ha ingresado todos los datos requeridos. Porfavor verificar");
			}
			System.out.println(dto.toString());
			this.iuUsuarioRepository.save(UsuarioHelper.toUsuarioEntity(dto));
			response.setSuccess(true);
			response.setMessage("El usuario fue almacenado satisfactorio");
		}catch(Exception e) {
			response.setSuccess(false);
			response.setMessage("Se ha presentado un error en el almacenamiento del usuario");
		}
		
		return response;
	}
	
	public UsuarioDTO findByDocumento(String documento) {
		Optional<Usuario> optUsuario = this.iuUsuarioRepository.findByDocumento(documento);
		return UsuarioHelper.toUsuarioDTO(optUsuario.orElse(null));
	}
	
	public UsuarioDTO modificar(UsuarioDTO usuario) {
		return null;
	}
	
	public UsuarioDTO eliminar(UsuarioDTO usuario) {
		return null;
	}
	
	public UsuarioDTO findByUserName(String userName) {
		return null;
	}
}
