package com.T2.LP2_T2_SOTELO_CARLOS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.T2.LP2_T2_SOTELO_CARLOS.model.OrdenCompra;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {
	List<OrdenCompra>findAllByOrderByNroOrdenDesc();
}
