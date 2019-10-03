package com.restaurante.lamejorcocina.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurante.lamejorcocina.entity.Factura;

@Repository
public class FacturaDAOImpl implements FacturaDAO {

	// define field for entity manager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public FacturaDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Factura> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Factura> theQuery = currentSession.createQuery("from Factura", Factura.class);
		
		List<Factura> facturas = theQuery.getResultList();
		
		return facturas;
	}

	@Override
	public Factura findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Factura theFactura = currentSession.get(Factura.class, theId);
		
		return theFactura;
	}

	@Override
	public void save(Factura theFactura) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theFactura);
		
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Factura where id=:facturaId");
		theQuery.setParameter("facturaId", theId);
		theQuery.executeUpdate();
	}

}
