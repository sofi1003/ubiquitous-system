package com.unal.unchazapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "negocios")
@Data
@NoArgsConstructor
public class Negocio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNegocio;
	
	@Column(name = "nombre_negocio", length = 20, unique = true)
	private String nombreNegocio;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "categoria", length = 50)
	private Categoria categoriaNegocio;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_de_negocio", length = 50 )
	private TipoDeNegocio tipoDeNegocio;
	
	@Column(name = "descripcion_negocio", length = 300)
	private String descripcionNegocio;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	
	
	

}
