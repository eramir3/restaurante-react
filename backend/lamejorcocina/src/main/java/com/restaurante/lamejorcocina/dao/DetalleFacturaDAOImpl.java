package com.restaurante.lamejorcocina.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurante.lamejorcocina.entity.DetalleFactura;

@Repository
public class DetalleFacturaDAOImpl implements DetalleFacturaDAO {

	private EntityManager entityManager;
	
	@Autowired
	public DetalleFacturaDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<DetalleFactura> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);

		Query<DetalleFactura> theQuery = currentSession.createQuery("from DetalleFactura", DetalleFactura.class);
		
		List<DetalleFactura> detalleFacturas = theQuery.getResultList();
		
		return detalleFacturas;
	}

	@Override
	public DetalleFactura findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		DetalleFactura theDetalleFactura = currentSession.get(DetalleFactura.class, theId);
		
		return theDetalleFactura;
	}

	@Override
	public void save(DetalleFactura theDetalleFactura) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theDetalleFactura);
		
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from DetalleFactura where id=:detalleFacturaId");
		theQuery.setParameter("detalleFacturaId", theId);
		theQuery.executeUpdate();
	}

}
