package com.restaurante.lamejorcocina.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurante.lamejorcocina.dto.ClienteImporteTotalDTO;
import com.restaurante.lamejorcocina.entity.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

	private EntityManager entityManager;

	@Autowired
	public ClienteDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	// Original
	/*
	@Override
	public List<Cliente> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<Cliente> theQuery = currentSession.createQuery("from Cliente", Cliente.class);
		
		List<Cliente> clientes = theQuery.getResultList();
		
		return clientes;
		
	}
	*/
	
	// Native query con mapping sencillo a la entidad (1 sola entidad)
	/*
	@Override
	public List<Cliente> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
			
		Query<Cliente> theQuery = currentSession.createNativeQuery("SELECT c.id as clienteId, c.nombre, c.apellido1, c.apellido2, c.observaciones FROM Cliente c", "ClienteMapping");

		List<Cliente> clientes = theQuery.getResultList();
			
		return clientes;
			
	}
 	*/
	
	// Native Query con mapping a dto (2 entidades)
	@Override
	public List<Cliente> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		
		//Query<Cliente> theQuery = currentSession.createNativeQuery("SELECT f.id as facturaId, f.fecha_factura, c.id as clienteId, c.nombre, c.apellido1, c.apellido2, c.observaciones FROM Factura f JOIN Cliente c ON f.cliente_id = c.id", "FacturaClienteDTO");
		Query<Cliente> theQuery = currentSession.createNamedQuery("FacturaClienteDTO");
		
		List<Cliente> clientes = theQuery.getResultList();
		
		return clientes;
		
	}

	@Override
	public Cliente findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Cliente theCliente = currentSession.get(Cliente.class, theId);
		
		return theCliente;
	}

	@Override
	public void save(Cliente theCliente) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theCliente);
		
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Cliente where id=:clienteId");
		theQuery.setParameter("clienteId", theId);
		theQuery.executeUpdate();
	}
	
	@Override
	public List<Object> findByImporteTotal() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createNativeQuery(FIND_BY_SAL_RNG);
		
		List<Object> detalleFactura = theQuery.getResultList();
		
		return detalleFactura;
	}
	
	@Override
	public List<ClienteImporteTotalDTO> findByImporteTotal2() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ClienteImporteTotalDTO> theQuery = currentSession.createNamedQuery("ClienteImporteTotalDTO");
		
		List<ClienteImporteTotalDTO> clientes = theQuery.getResultList();
		
		return clientes;
	}
	
	// Mapear a dto con for loop
	/*
	@Override
	public List<ClienteImporteTotalDTO> findByImporteTotal2() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createNativeQuery(FIND_BY_SAL_RNG2);
		
		List<ClienteImporteTotalDTO> dtoList = new ArrayList<>();
		
		List<Object[]> results = theQuery.getResultList();
		
		results.stream().forEach((record) -> {
		
	        String nombre = (String) record[0];
	        String apellido1 = (String) record[1];
	        String apellido2 = (String) record[2];
	        double importe = (double) record[3];
	        int id = (int) record[4];
	        
	        ClienteImporteTotalDTO dto = new ClienteImporteTotalDTO();
	        dto.setId(id);
	        dto.setNombre(nombre);
	        dto.setApellido1(apellido1);
	        dto.setApellido2(apellido2);
	        dto.setImporte(importe);
	        
	        dtoList.add(dto);
		});
		
		return dtoList;
	}
	*/
}
