package com.restaurante.lamejorcocina.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurante.lamejorcocina.entity.Mesa;

@Repository
public class MesaDAOImpl implements MesaDAO {

	private EntityManager entityManager;
	
	@Autowired
	public MesaDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Mesa> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Mesa> theQuery = currentSession.createQuery("from Mesa", Mesa.class);
		
		List<Mesa> mesas = theQuery.getResultList();
		
		return mesas;
	}

	@Override
	public Mesa findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Mesa theMesa = currentSession.get(Mesa.class, theId);
		
		return theMesa;
	}

	@Override
	public void save(Mesa theMesa) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theMesa);
		
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Mesa where id=:mesaId");
		theQuery.setParameter("mesaId", theId);
		theQuery.executeUpdate();
	}

}
