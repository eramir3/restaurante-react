package com.restaurante.lamejorcocina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.lamejorcocina.dao.ClienteDAO;
import com.restaurante.lamejorcocina.dao.MesaDAO;
import com.restaurante.lamejorcocina.dto.ClienteImporteTotalDTO;
import com.restaurante.lamejorcocina.entity.Cliente;
import com.restaurante.lamejorcocina.entity.Mesa;

@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteDAO clienteDAO;
	
	private MesaDAO mesaDAO;
	
	@Autowired
	public ClienteServiceImpl(ClienteDAO theClienteDAO, MesaDAO theMesaDAO) {
		clienteDAO = theClienteDAO;
		mesaDAO = theMesaDAO;
	}
	
	@Override
	@Transactional
	public List<Cliente> findAll() {
		return clienteDAO.findAll();
	}

	@Override
	@Transactional
	public Cliente findById(int theId) {
		return clienteDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Cliente theCliente) {
		clienteDAO.save(theCliente);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		clienteDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public List<Object> findByImporteTotal() {
		return clienteDAO.findByImporteTotal();
	}

	public List<ClienteImporteTotalDTO> findByImporteTotal2() {
		return clienteDAO.findByImporteTotal2();
	}
}
