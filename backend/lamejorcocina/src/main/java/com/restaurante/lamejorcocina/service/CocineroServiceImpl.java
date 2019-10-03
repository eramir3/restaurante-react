package com.restaurante.lamejorcocina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.lamejorcocina.dao.CocineroDAO;
import com.restaurante.lamejorcocina.entity.Cocinero;

@Service
public class CocineroServiceImpl implements CocineroService {

	private CocineroDAO cocineroDAO;
	
	@Autowired
	public CocineroServiceImpl(CocineroDAO theCocineroDAO) {
		cocineroDAO = theCocineroDAO;
	}
	
	@Override
	@Transactional
	public List<Cocinero> findAll() {
		return cocineroDAO.findAll();
	}

	@Override
	@Transactional
	public Cocinero findById(int theId) {
		return cocineroDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Cocinero theCocinero) {
		cocineroDAO.save(theCocinero);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		cocineroDAO.deleteById(theId);
	}

}
