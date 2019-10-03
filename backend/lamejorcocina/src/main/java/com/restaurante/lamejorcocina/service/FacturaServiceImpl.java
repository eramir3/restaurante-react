package com.restaurante.lamejorcocina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.lamejorcocina.dao.FacturaDAO;
import com.restaurante.lamejorcocina.entity.Factura;

@Service
public class FacturaServiceImpl implements FacturaService {

	private FacturaDAO facturaDAO;
	
	@Autowired
	public FacturaServiceImpl(FacturaDAO theFacturaDAO) {
		facturaDAO = theFacturaDAO;
	}
	
	@Override
	@Transactional
	public List<Factura> findAll() {
		return facturaDAO.findAll();
	}

	@Override
	@Transactional
	public Factura findById(int theId) {
		return facturaDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Factura theFactura) {
		facturaDAO.save(theFactura);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		facturaDAO.deleteById(theId);
	}

}
