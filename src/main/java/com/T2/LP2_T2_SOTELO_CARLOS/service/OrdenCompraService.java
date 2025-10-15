package com.T2.LP2_T2_SOTELO_CARLOS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.T2.LP2_T2_SOTELO_CARLOS.dto.ResultadoResponse;
import com.T2.LP2_T2_SOTELO_CARLOS.model.OrdenCompra;

import com.T2.LP2_T2_SOTELO_CARLOS.repository.OrdenCompraRepository;


@Service
public class OrdenCompraService {
	
	@Autowired
	private OrdenCompraRepository repoOrden;
	
	public List<OrdenCompra> getAll(){
		return repoOrden.findAllByOrderByNroOrdenDesc();
	}

	public ResultadoResponse create(OrdenCompra orden) {
		try {
			OrdenCompra inventarioRegistrado = repoOrden.save(orden);
			
			String mensaje = String.format("Orden de compra Nro %s Registrada", inventarioRegistrado.getNroOrden());
			return new ResultadoResponse(true, mensaje);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Error en OrdenService: "+ e.getMessage());
		}
	}
	
	public OrdenCompra getOne(Integer id) {
		return repoOrden.findById(id).orElseThrow();
	}
	
	public ResultadoResponse update(OrdenCompra orden) {
		try {
			OrdenCompra inventarioRegistrado = repoOrden.save(orden);
			
			String mensaje = String.format("Orden de compra Nro %s Actualizada", inventarioRegistrado.getNroOrden());
			return new ResultadoResponse(true, mensaje);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Error en OrdenService: "+ e.getMessage());
		}
	}
}
