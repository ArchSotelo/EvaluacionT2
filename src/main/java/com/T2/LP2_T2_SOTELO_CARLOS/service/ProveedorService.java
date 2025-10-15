package com.T2.LP2_T2_SOTELO_CARLOS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.T2.LP2_T2_SOTELO_CARLOS.model.Proveedor;

import com.T2.LP2_T2_SOTELO_CARLOS.repository.ProveedorRepository;


@Service
public class ProveedorService {
	
	@Autowired
	private ProveedorRepository repoProve;
	
	public List<Proveedor> getAll(){
		return repoProve.findAll();
	}
}
