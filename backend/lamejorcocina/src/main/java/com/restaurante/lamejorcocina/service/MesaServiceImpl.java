package com.restaurante.lamejorcocina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.lamejorcocina.dao.MesaDAO;
import com.restaurante.lamejorcocina.entity.Mesa;

@Service
public class MesaServiceImpl implements MesaService {

	private MesaDAO mesaDAO;
	
	@Autowired
	public MesaServiceImpl(MesaDAO theMesaDAO) {
		mesaDAO = theMesaDAO;
	}
	
	@Override
	@Transactional
	public List<Mesa> findAll() {
		return mesaDAO.findAll();
	}

	@Override
	@Transactional
	public Mesa findById(int theId) {
		return mesaDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Mesa theMesa) {
		mesaDAO.save(theMesa);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		mesaDAO.deleteById(theId);
	}

}
