package com.unal.unchazapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unal.unchazapp.domain.Usuario;



public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	public Optional<Usuario> findByDocumento(@Param("documento") String documento);
	
	public Optional<Usuario> findByUserName(@Param("user_name")String userName);
	
	@Query(value = "select * from usuarios where user_name = :userName and password = :password", nativeQuery = true)
	public Optional<Usuario> autenticar(@Param("userName") String userName, @Param("password") String password);
	

}
