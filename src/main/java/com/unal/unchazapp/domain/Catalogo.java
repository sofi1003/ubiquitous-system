package com.unal.unchazapp.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "catalogos")
@Data
public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCatalogo;
    
    @Column(name = "nombre", length = 300)
    private String nombre;
    

    @OneToMany(mappedBy = "catalogo")
    private List<Producto> productos;
    
    @ManyToOne
    @JoinColumn(name = "id_negocio", nullable = false)
    private Negocio negocio;

}