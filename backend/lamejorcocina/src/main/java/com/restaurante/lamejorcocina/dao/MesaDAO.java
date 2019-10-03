package com.restaurante.lamejorcocina.dao;

import java.util.List;

import com.restaurante.lamejorcocina.entity.Mesa;

public interface MesaDAO {

	public List<Mesa> findAll();
	
	public Mesa findById(int theId);
	
	public void save(Mesa theMesa);
	
	public void deleteById(int theId);
}
