package com.restaurante.lamejorcocina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.lamejorcocina.dao.DetalleFacturaDAO;
import com.restaurante.lamejorcocina.entity.DetalleFactura;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {

	private DetalleFacturaDAO detalleFacturaDAO;
	
	@Autowired
	public DetalleFacturaServiceImpl(DetalleFacturaDAO theDetalleFacturaDAO) {
		detalleFacturaDAO = theDetalleFacturaDAO;
	}
	
	@Override
	@Transactional
	public List<DetalleFactura> findAll() {
		return detalleFacturaDAO.findAll();
	}

	@Override
	@Transactional
	public DetalleFactura findById(int theId) {
		return detalleFacturaDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(DetalleFactura theDetalleFactura) {
		detalleFacturaDAO.save(theDetalleFactura);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		detalleFacturaDAO.deleteById(theId);
	}

}
