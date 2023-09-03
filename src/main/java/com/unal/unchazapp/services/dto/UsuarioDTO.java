package com.unal.unchazapp.services.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsuario;
	private String documento;
	private String userName;
	private String password;
	private String email;
}
