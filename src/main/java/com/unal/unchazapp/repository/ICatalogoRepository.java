package com.unal.unchazapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unal.unchazapp.domain.Catalogo;

public interface ICatalogoRepository extends JpaRepository<Catalogo, Long>{

}
