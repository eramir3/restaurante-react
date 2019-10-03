package com.restaurante.lamejorcocina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.lamejorcocina.dao.CamareroDAO;
import com.restaurante.lamejorcocina.dto.CamareroFacturadoTotalDTO;
import com.restaurante.lamejorcocina.entity.Camarero;

@Service
public class CamareroServiceImpl implements CamareroService {

	private CamareroDAO camareroDAO;
	
	@Autowired
	public CamareroServiceImpl(CamareroDAO theCamareroDAO) {
		camareroDAO = theCamareroDAO;
	}
	
	@Override
	@Transactional
	public List<Camarero> findAll() {
		return camareroDAO.findAll();
	}

	@Override
	@Transactional
	public Camarero findById(int theId) {
		return camareroDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Camarero theCamarero) {
		camareroDAO.save(theCamarero);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		camareroDAO.deleteById(theId);
	}

	@Override
	public List<Object> findByTotalFacturado() {
		return camareroDAO.findByTotalFacturado();
	}

	@Override
	public List<CamareroFacturadoTotalDTO> findByTotalFacturado2() {
		return camareroDAO.findByTotalFacturado2();
	}

}
