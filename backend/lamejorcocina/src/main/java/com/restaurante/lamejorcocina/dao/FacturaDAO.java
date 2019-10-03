package com.restaurante.lamejorcocina.dao;

import java.util.List;

import com.restaurante.lamejorcocina.entity.Factura;

public interface FacturaDAO {

	public List<Factura> findAll();
	
	public Factura findById(int theId);
	
	public void save(Factura theFactura);
	
	public void deleteById(int theId);
}
