package com.T2.LP2_T2_SOTELO_CARLOS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.T2.LP2_T2_SOTELO_CARLOS.model.Rubro;
import com.T2.LP2_T2_SOTELO_CARLOS.repository.RubroRepository;

@Service
public class RubroService {
	
	@Autowired
	private RubroRepository repoRubro;
	
	public List<Rubro> getAll(){
		return repoRubro.findAll();
	}
}
