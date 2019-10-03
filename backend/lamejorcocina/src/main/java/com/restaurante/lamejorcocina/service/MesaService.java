package com.restaurante.lamejorcocina.service;

import java.util.List;

import com.restaurante.lamejorcocina.entity.Mesa;

public interface MesaService {

	public List<Mesa> findAll();
	
	public Mesa findById(int theId);
	
	public void save(Mesa theMesa);
	
	public void deleteById(int theId);
}
