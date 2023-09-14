package com.unal.unchazapp.services;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unal.unchazapp.controller.dto.LoginDTO;
import com.unal.unchazapp.controller.dto.ResponseDTO;
import com.unal.unchazapp.controller.dto.ResponseLoginDTO;
import com.unal.unchazapp.domain.Usuario;
import com.unal.unchazapp.repository.IUsuarioRepository;
import com.unal.unchazapp.services.dto.UsuarioDTO;
import com.unal.unchazapp.services.helper.UsuarioHelper;

import java.util.regex.Matcher;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository iuUsuarioRepository;
	
	@Autowired
    private EmailService emailService;
	
	private final String allowedDomain = "unal.edu.co";

	public ResponseDTO crear(UsuarioDTO dto) {
		ResponseDTO response = new ResponseDTO();
		try {
			if (Objects.isNull(dto)) {
				response.setSuccess(false);
				response.setMessage("No ha ingresado todos los datos requeridos. Por favor verificar");
			}
			System.out.println(dto.toString());
			String regex = "^[A-Za-z0-9+_.-]+@(" + Pattern.quote(allowedDomain) + ")$";

			Pattern pattern = Pattern.compile(regex);

			Matcher matcher = pattern.matcher(dto.getEmail());
			if (matcher.matches()) {
				this.iuUsuarioRepository.save(UsuarioHelper.toUsuarioEntity(dto));
				
				String email = dto.getEmail(); 
	            String subject = "Validación de Correo Electrónico";
	            String text = "Por favor, haga clic en el siguiente enlace para validar su correo electrónico: https://tuapp.com/validar?token=token_de_validacion";
	            emailService.sendEmail(email , subject, text);
				
				response.setSuccess(true);
				response.setMessage("El usuario fue almacenado satisfactorio");
			} else {
				response.setSuccess(false);
				response.setMessage("El correo electronico del usuario no pertenece al dominio de la universidad");
			}
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage("Se ha presentado un error en el almacenamiento del usuario");
		}

		return response;
	}
	
	public ResponseLoginDTO login(LoginDTO loginDTO) {
		ResponseLoginDTO response = new ResponseLoginDTO();
		Optional<Usuario> optUser = this.iuUsuarioRepository.autenticar(loginDTO.getUserName(), loginDTO.getPassword());
		if(optUser.isPresent()){
			Usuario user = optUser.get();			
			response.setSuccess(true);
			response.setMessage("El usuario se autenticó satisfactoriamente.");
			response.setNumeroDocumento(user.getDocumento());
			response.setUser(user.getUserName());			
		}else{
			response.setSuccess(false);
			response.setMessage("Datos de usuario incorrectos.");
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
		ResponseDTO response = new ResponseDTO();
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
