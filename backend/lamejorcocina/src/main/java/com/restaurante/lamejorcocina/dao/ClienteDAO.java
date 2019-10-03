package com.restaurante.lamejorcocina.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.restaurante.lamejorcocina.dto.ClienteImporteTotalDTO;
import com.restaurante.lamejorcocina.entity.Cliente;

public interface ClienteDAO {

	public String FIND_BY_SAL_RNG = "SELECT * FROM \n" + 
			"	(SELECT cliente.nombre as nombre, cliente.apellido1 as apellido1, cliente.apellido2 as apellido2, SUM(importe) as importe_total FROM detalle_factura\n" + 
			"	JOIN factura ON factura.id = detalle_factura.factura_id\n" + 
			"	JOIN cliente ON cliente.id = factura.cliente_id\n" + 
			"	GROUP BY cliente.id ) AS result\n" + 
			"	WHERE importe_total > 100000";
	
	public String FIND_BY_SAL_RNG2 = "SELECT * FROM \n" + 
			"	(SELECT cliente.nombre as nombre, cliente.apellido1 as apellido1, cliente.apellido2 as apellido2, SUM(importe) as importe, cliente.id as id FROM detalle_factura\n" + 
			"	JOIN factura ON factura.id = detalle_factura.factura_id\n" + 
			"	JOIN cliente ON cliente.id = factura.cliente_id\n" + 
			"	GROUP BY cliente.id ) AS result\n" + 
			"	WHERE importe >= 100000";
	
	public List<Cliente> findAll();
	
	public Cliente findById(int theId);
	
	public void save(Cliente theCliente);
	
	public void deleteById(int theId); 
	
	public List<Object> findByImporteTotal();
	
	
	
	public List<ClienteImporteTotalDTO> findByImporteTotal2();
}
