package com.restaurante.lamejorcocina.service;

import java.util.List;

import com.restaurante.lamejorcocina.dto.ClienteImporteTotalDTO;
import com.restaurante.lamejorcocina.entity.Cliente;

public interface ClienteService {

	public List<Cliente> findAll();
	
	public Cliente findById(int theId);
	
	public void save(Cliente theCliente);
	
	public void deleteById(int theId);
	
	public List<Object> findByImporteTotal();
	
	public List<ClienteImporteTotalDTO> findByImporteTotal2();

}
