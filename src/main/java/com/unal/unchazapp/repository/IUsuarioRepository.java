package com.unal.unchazapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unal.unchazapp.domain.Usuario;


public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	//@Query(value = "select * from usuarios where documento = :documento", nativeQuery = true)
	public Optional<Usuario> findByDocumento(@Param("documento") String documento);

}
