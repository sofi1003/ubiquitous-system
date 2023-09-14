package com.unal.unchazapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unal.unchazapp.domain.Negocio;

public interface INegocioRepository extends JpaRepository<Negocio, Long>{

}
