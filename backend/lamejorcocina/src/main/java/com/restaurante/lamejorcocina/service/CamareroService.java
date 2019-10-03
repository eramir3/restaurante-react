package com.restaurante.lamejorcocina.service;

import java.util.List;

import com.restaurante.lamejorcocina.dto.CamareroFacturadoTotalDTO;
import com.restaurante.lamejorcocina.entity.Camarero;

public interface CamareroService {

	public List<Camarero> findAll();
	
	public Camarero findById(int theId);
	
	public void save(Camarero theCamarero);
	
	public void deleteById(int theId);
	
	public List<Object> findByTotalFacturado();
	
	public List<CamareroFacturadoTotalDTO> findByTotalFacturado2();
}
