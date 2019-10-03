package com.restaurante.lamejorcocina.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.restaurante.lamejorcocina.entity.DetalleFactura;

public interface DetalleFacturaDAO {

	public List<DetalleFactura> findAll();
	
	public DetalleFactura findById(int theId);
	
	public void save(DetalleFactura theFactura);
	
	public void deleteById(int theId);
	
}
