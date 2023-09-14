package com.unal.unchazapp.services;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unal.unchazapp.controller.dto.ResponseDTO;
import com.unal.unchazapp.domain.Usuario;
import com.unal.unchazapp.repository.IUsuarioRepository;
import com.unal.unchazapp.services.dto.UsuarioDTO;
import com.unal.unchazapp.services.helper.UsuarioHelper;

import java.util.regex.Matcher;

@Service
public class UsuarioService {
	
	@Autowired
	private IUsuarioRepository iuUsuarioRepository;
	private final String allowedDomain = "unal.edu.co";

	
		public ResponseDTO crear(UsuarioDTO dto) {
			ResponseDTO response =  new ResponseDTO();
			try	{
				if(Objects.isNull(dto)) {
					response.setSuccess(false);
					response.setMessage("No ha ingresado todos los datos requeridos. Porfavor verificar");
				}
				System.out.println(dto.toString());
				String regex = "^[A-Za-z0-9+_.-]+@(" + Pattern.quote(allowedDomain) + ")$";

		        Pattern pattern = Pattern.compile(regex);

		        Matcher matcher = pattern.matcher(dto.getEmail());
				if (matcher.matches()) {
					this.iuUsuarioRepository.save(UsuarioHelper.toUsuarioEntity(dto));
					response.setSuccess(true);
					response.setMessage("El usuario fue almacenado satisfactorio");
				}else {
					response.setSuccess(false);
					response.setMessage("El correo electronico del usuario no pertenece al dominio de la universidad");
					
				}
				
				
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
	
	public UsuarioDTO findByUserName(String userName) {
		Optional<Usuario> optUsuario = this.iuUsuarioRepository.findByUserName(userName);
		return UsuarioHelper.toUsuarioDTO(optUsuario.orElse(null));
	}
	
	public ResponseDTO modificar(UsuarioDTO dtoActualizado, String documento) {
		ResponseDTO response =  new ResponseDTO();
		Optional<Usuario> optUsuario = this.iuUsuarioRepository.findByDocumento(documento);
		Usuario usuarioExistente = UsuarioHelper.toUsuarioEntity(UsuarioHelper.toUsuarioDTO(optUsuario.orElse(null)));
		usuarioExistente.setPassword(dtoActualizado.getPassword());
		usuarioExistente.setUserName(dtoActualizado.getUserName());
		this.iuUsuarioRepository.save(usuarioExistente);
		response.setSuccess(true);
		response.setMessage("Se ha modificado el usuario");
		
		return response;
		}

	
	
}
