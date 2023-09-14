package com.unal.unchazapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unal.unchazapp.domain.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long>{

}
