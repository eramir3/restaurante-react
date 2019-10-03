package com.restaurante.lamejorcocina.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.restaurante.lamejorcocina.entity.DetalleFactura;

public interface DetalleFacturaService {

	public List<DetalleFactura> findAll();
	
	public DetalleFactura findById(int theId);
	
	public void save(DetalleFactura theDetalleFactura);
	
	public void deleteById(int theId);
	
}
