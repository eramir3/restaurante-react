package com.restaurante.lamejorcocina.dao;

import java.util.List;

import com.restaurante.lamejorcocina.dto.CamareroFacturadoTotalDTO;
import com.restaurante.lamejorcocina.entity.Camarero;

public interface CamareroDAO {

	public String FIND_CAMAREROS = "SELECT camarero.nombre, camarero.apellido1, camarero.apellido2, SUM(detalle_factura.importe) AS total_facturado,\n" + 
			"	SUM(CASE WHEN fecha_factura >= '2019-01-01' AND fecha_factura <= '2019-01-31' \n" + 
			"		THEN detalle_factura.importe ELSE 0 END) AS enero,\n" + 
			"	SUM(CASE WHEN fecha_factura >= '2019-02-01' AND fecha_factura <= '2019-02-28' \n" + 
			"		THEN detalle_factura.importe ELSE 0 END) AS febrero,\n" + 
			"	SUM(CASE WHEN fecha_factura >= '2019-03-01' AND fecha_factura <= '2019-03-31' \n" + 
			"		THEN detalle_factura.importe ELSE 0 END) AS marzo,\n" + 
			"	SUM(CASE WHEN fecha_factura >= '2019-04-01' AND fecha_factura <= '2019-04-30' \n" + 
			"		THEN detalle_factura.importe ELSE 0 END) AS abril,\n" + 
			"	SUM(CASE WHEN fecha_factura >= '2019-05-01' AND fecha_factura <= '2019-05-31' \n" + 
			"		THEN detalle_factura.importe ELSE 0 END) AS mayo,\n" + 
			"	SUM(CASE WHEN fecha_factura >= '2019-06-01' AND fecha_factura <= '2019-06-30' \n" + 
			"		THEN detalle_factura.importe ELSE 0 END) AS junio,\n" + 
			"	SUM(CASE WHEN fecha_factura >= '2019-07-01' AND fecha_factura <= '2019-07-31' \n" + 
			"		THEN detalle_factura.importe ELSE 0 END) AS julio,\n" + 
			"	SUM(CASE WHEN fecha_factura >= '2019-08-01' AND fecha_factura <= '2019-08-31' \n" + 
			"		THEN detalle_factura.importe ELSE 0 END) AS agosto,\n" + 
			"	SUM(CASE WHEN fecha_factura >= '2019-09-01' AND fecha_factura <= '2019-09-30' \n" + 
			"		THEN detalle_factura.importe ELSE 0 END) AS septiembre,\n" + 
			"	SUM(CASE WHEN fecha_factura >= '2019-10-01' AND fecha_factura <= '2019-10-31' \n" + 
			"		THEN detalle_factura.importe ELSE 0 END) AS octubre,\n" + 
			"	SUM(CASE WHEN fecha_factura >= '2019-11-01' AND fecha_factura <= '2019-11-30' \n" + 
			"		THEN detalle_factura.importe ELSE 0 END) AS noviembre,\n" + 
			"	SUM(CASE WHEN fecha_factura >= '2019-12-01' AND fecha_factura <= '2019-12-31' \n" + 
			"		THEN detalle_factura.importe ELSE 0 END) AS diciembre\n" + 
			"FROM camarero\n" + 
			"LEFT JOIN factura ON factura.camarero_id = camarero.id\n" + 
			"LEFT JOIN detalle_factura ON detalle_factura.factura_id = factura.id\n" + 
			"GROUP BY camarero.id";
	
	public List<Camarero> findAll();
	
	public Camarero findById(int theId);
	
	public void save(Camarero theCamarero);
	
	public void deleteById(int theId);
	
	public List<Object> findByTotalFacturado();
	
	public List<CamareroFacturadoTotalDTO> findByTotalFacturado2();
}
