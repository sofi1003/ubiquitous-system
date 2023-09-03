package com.unal.unchazapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	@Column(name = "documento", length = 20, unique = true)
	private String documento;
	@Column(name = "user_name", length = 20, unique = true)
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "email", length = 50, unique = true)
	private String email;
	

}
