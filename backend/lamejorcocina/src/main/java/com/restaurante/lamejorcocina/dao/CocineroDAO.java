package com.restaurante.lamejorcocina.dao;

import java.util.List;

import com.restaurante.lamejorcocina.entity.Cocinero;

public interface CocineroDAO {

	public List<Cocinero> findAll();
	
	public Cocinero findById(int theId);
	
	public void save(Cocinero theCocinero);
	
	public void deleteById(int theId);
}
