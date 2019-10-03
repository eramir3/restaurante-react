package com.restaurante.lamejorcocina.service;

import java.util.List;

import com.restaurante.lamejorcocina.entity.Cocinero;

public interface CocineroService {

	public List<Cocinero> findAll();
	
	public Cocinero findById(int theId);
	
	public void save(Cocinero theCocinero);
	
	public void deleteById(int theId);
}
