package com.restaurante.lamejorcocina.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurante.lamejorcocina.entity.Cocinero;

@Repository
public class CocineroDAOImpl implements CocineroDAO {

	private EntityManager entityManager;
	
	@Autowired
	public CocineroDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Cocinero> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Cocinero> theQuery = currentSession.createQuery("from Cocinero", Cocinero.class);
		
		List<Cocinero> cocineros = theQuery.getResultList();
		
		return cocineros;
	}

	@Override
	public Cocinero findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Cocinero theCocinero = currentSession.get(Cocinero.class, theId);
		
		return theCocinero;
	}

	@Override
	public void save(Cocinero theCocinero) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theCocinero);
		
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Cocinero where id=:cocineroId");
		theQuery.setParameter("cocineroId", theId);
		theQuery.executeUpdate();
	}

}
